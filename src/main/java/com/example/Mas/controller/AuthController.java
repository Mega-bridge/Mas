package com.example.Mas.controller;

import com.example.Mas.model.SignIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody SignIn signIn) {

        //TODO 인증로직 추가해야함
        return ResponseEntity.ok(true);
    }
}
