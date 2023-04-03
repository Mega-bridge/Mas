package com.example.Mas.controller;

import com.example.Mas.model.User;
import com.example.Mas.service.UserService;
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

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.findAll();
        if(userList == null) {
            log.error("find user list error: {}", userList);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id) {
        User user = userService.findById(id);
        if(user == null) {
//            log.error("find id error: {}", id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/username")
    public ResponseEntity<User> findByUsername(@RequestParam(value = "username") String username) {
        User user = userService.findByUsername(username);
        if(user == null) {
//            log.error("find username error: {}", username);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email")
    public ResponseEntity<User> findByEmail(@RequestParam(value = "email") String email) {
        User user = userService.findByEmail(email);
        if(user == null) {
            log.error("find email error: {}", email);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }
}
