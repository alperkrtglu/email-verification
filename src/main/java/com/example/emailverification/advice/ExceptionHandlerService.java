package com.example.emailverification.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.MessagingException;

@RestControllerAdvice
public class ExceptionHandlerService {

    @ExceptionHandler(MessagingException.class)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String handleMessagingException() {
        return "An error occurred while sending the confirmation mail.";
    }
}
