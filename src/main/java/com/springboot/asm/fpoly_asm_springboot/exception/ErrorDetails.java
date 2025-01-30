package com.in28minutes.webservices.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime timestamp;

    private String message;

    private String details;


}
