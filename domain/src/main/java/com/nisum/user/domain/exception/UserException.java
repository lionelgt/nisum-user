package com.nisum.user.domain.exception;

import lombok.Data;

@Data
public class UserException extends RuntimeException{
    private String code;
    protected Integer httpCode;

    public UserException(String code, String msg, Throwable e) {
        super(String.format("[%s] %s", code, msg), e);
        this.code = code;
    }
    public UserException(String code, String msg, Integer httpCode ) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
        this.httpCode = httpCode;
    }
    public UserException(String code, String msg) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
    }
    public UserException(String code) {
        super(String.format("[%s]", code));
        this.code = code;
    }
    public UserException(String code, Integer httpCode) {
        super(String.format("[%s]", code));
        this.code = code;
        this.httpCode = httpCode;
    }
    public UserException(String msg, Throwable e) {
        this("DEFAULT", msg, e);
    }
}
