package com.example.Mas.model;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor //need default constructor for JSON Parsing
@AllArgsConstructor
public class SignIn implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String email;
    private String password;
}
