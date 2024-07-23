package com.vti.LoginAndWeb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        var messages = "Sorry! Invalid Input";
        var errors = new HashMap<String,String>();
        for (var error : exception.getFieldErrors()) {
            var key = error.getField();
            var value = error.getDefaultMessage();
            errors.put(key,value);
        }
        var response = new ErrorResponse(messages,errors);
        return new ResponseEntity<>(response,headers,status);
    }
}
