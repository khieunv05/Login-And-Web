package com.vti.LoginAndWeb.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private String timestamp = LocalDateTime.now().toString();
    private String messages;
    private Map<String,String> error;

    public ErrorResponse(String messages) {
        this.messages = messages;
        error = null;
    }

    public ErrorResponse(String messages, Map<String, String> error) {
        this.messages = messages;
        this.error = error;
    }
}
