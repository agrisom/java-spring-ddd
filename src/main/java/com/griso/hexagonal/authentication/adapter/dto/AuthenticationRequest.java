package com.griso.hexagonal.authentication.adapter.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
    
}
