package com.nisum.user.api.advice;

import lombok.Data;

@Data
public class CustomResponseEntity<T> {
    private String message;
    private String errorCode;
    private T data;
}
