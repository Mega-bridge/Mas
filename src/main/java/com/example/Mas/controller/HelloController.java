package com.example.Mas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HelloController {
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {

        return "hello world";
    }
}
