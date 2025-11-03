package com.hitss.springboot.gestortareas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomExceptions extends RuntimeException {
    public CustomExceptions(String message) {
        super(message);
    }
}

@Data
@AllArgsConstructor
class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}