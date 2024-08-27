package com.thayluantutor.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String full_name;
    private String email;
    private String password;
}
