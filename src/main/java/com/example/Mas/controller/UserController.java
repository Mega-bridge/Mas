package com.example.Mas.controller;

import com.example.Mas.model.User;
import com.example.Mas.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "사용자 생성", description = "사용자를 생성한다.(회원가입)", method = "POST")
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        } catch (DuplicateKeyException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Operation(summary = "전체 사용자 조회", description = "전체 사용자를 조회한다.", method = "GET")
    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.findAll();
        if(userList == null) {
            log.error("사용자 정보를 찾을 수 없습니다.[userList: null]");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userList);
    }

    @Operation(summary = "사용자 조회", description = "사용자 아이디로 사용자를 조회한다.", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(
            @Parameter(name = "id", description = "user.id", required = true) @PathVariable("id") int id) {
        User user = userService.findById(id);
        if(user == null) {
            log.error("사용자 정보를 찾을 수 없습니다.[id: {}]", id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "사용자 조회", description = "사용자 이름으로 사용자를 조회한다.", method = "GET")
    @GetMapping("/username")
    public ResponseEntity<User> findByUsername(
            @Parameter(name = "name", description = "user.username", required = true) @RequestParam(value = "username") String username) {
        User user = userService.findByUsername(username);
        if(user == null) {
            log.error("사용자 정보를 찾을 수 없습니다.[username: {}]", username);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "사용자 조회", description = "사용자 이메일로 사용자를 조회한다.", method = "GET")
    @GetMapping("/email")
    public ResponseEntity<User> findByEmail(
            @Parameter(name = "email", description = "user.email", required = true) @RequestParam(value = "email") String email) {
        User user = userService.findByEmail(email);
        if(user == null) {
            log.error("사용자 정보를 찾을 수 없습니다.[email: {}]", email);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }
}
