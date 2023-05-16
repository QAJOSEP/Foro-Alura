package com.alura.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Clase S3
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {

    private String username;
    private String password;
}
