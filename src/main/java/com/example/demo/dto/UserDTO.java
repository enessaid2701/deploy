package com.example.demo.dto;

import lombok.Builder;

@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
}
