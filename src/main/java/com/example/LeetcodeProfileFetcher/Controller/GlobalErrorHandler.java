package com.example.LeetcodeProfileFetcher.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public String handleAnyException(Exception ex){
        return "error";
    }
}
