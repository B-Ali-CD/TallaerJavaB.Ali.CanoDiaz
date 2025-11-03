package com.hitss.springboot.gestortareas.security;


import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class TokenJwtConfig {

    public static final SecretKey SECRET_KEY =
        Keys.hmacShaKeyFor("mi_super_clave_segura_para_jwt_que_es_larga_123456789".getBytes());

    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
}