package com.example.EcommerceBackend.exceptions;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private int status;
    private String error;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();       // numeric (400, 404, etc.)
        this.error = status.getReasonPhrase(); // "Bad Request", "Not Found"
        this.timestamp = LocalDateTime.now();
    }
}
