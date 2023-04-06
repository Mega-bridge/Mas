package com.example.Mas.model;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResult {
    private String jwt;
    private Date jwtExpTime;
    private User user;
}
