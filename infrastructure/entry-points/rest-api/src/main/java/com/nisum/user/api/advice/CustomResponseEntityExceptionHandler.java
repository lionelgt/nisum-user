package com.nisum.user.api.advice;

import com.nisum.user.domain.exception.UserException;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Environment env;

    private static final String UNEXPECTED_ERROR_CODE = "unexpected.error";
    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error";
    
    @ExceptionHandler(value = {UserException.class})
    protected org.springframework.http.ResponseEntity<Object> handlerCore(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected org.springframework.http.ResponseEntity<Object> handlerException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected org.springframework.http.ResponseEntity<Object> handlerIllegalArgumentException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    public org.springframework.http.ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){
        String errorCode = UNEXPECTED_ERROR_CODE;
        String message = UNEXPECTED_ERROR_MESSAGE;
        HttpStatus finalStatus = status;
        
        if (ex instanceof UserException) {
            UserException exception = (UserException)ex;
            errorCode = exception.getCode();
            if(env.containsProperty(errorCode))
                message = env.getProperty(errorCode);
            else 
                message = exception.getMessage();
            if(exception.getHttpCode() != null) {
                finalStatus = HttpStatus.resolve(exception.getHttpCode());
            }
        }

        if (ex instanceof IllegalArgumentException) {
            errorCode = ex.getMessage();
            message = ex.getMessage();
            if(env.containsProperty(errorCode))
                message = env.getProperty(errorCode);
        }
        CustomResponseEntity<Object> customResponseEntity = new CustomResponseEntity();
        customResponseEntity.setErrorCode(errorCode);
        customResponseEntity.setMessage(message);
        log.error("code: [{}] message: [{}]", customResponseEntity.getErrorCode(), customResponseEntity.getMessage(), ex);
        return new ResponseEntity<>(customResponseEntity, headers, finalStatus);
    }
}
