package com.example.Mas.controller;

import com.example.Mas.config.JwtTokenUtil;
import com.example.Mas.config.JwtUserDetailsService;
import com.example.Mas.model.LoginResult;
import com.example.Mas.model.SignIn;
import com.example.Mas.model.User;
import com.example.Mas.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Operation(summary = "사용자 로그인", description = "사용자 로그인을 한다.", method = "POST")
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody SignIn signIn) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(signIn.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // 비밀번호 확인
        boolean matchPassword = bCryptPasswordEncoder.matches(signIn.getPassword(), userDetails.getPassword());
        if(!matchPassword) {
            log.error("사용자 비밀번호가 틀렸습니다.[user email: {}]", signIn.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // token으로 만료일 확인
        Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(token);
        // user 정보
        User user = userService.findByEmail(userDetails.getUsername());

        // 로그인 정보 반환
        LoginResult loginResult = new LoginResult();
        loginResult.setJwt(token);
        loginResult.setJwtExpTime(expirationDate);
        loginResult.setUser(user);
        return ResponseEntity.ok(loginResult);
    }

    @Operation(summary = "토큰 발급", description = "인증 토큰을 발행한다.", method = "POST")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SignIn signIn) throws Exception {
        authenticate(signIn.getEmail(), signIn.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(signIn.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
