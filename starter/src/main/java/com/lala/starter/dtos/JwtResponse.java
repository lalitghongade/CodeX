package com.lala.starter.dtos;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;
    private String username;
    
}
