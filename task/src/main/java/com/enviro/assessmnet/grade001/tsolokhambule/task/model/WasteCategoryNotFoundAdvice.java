package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WasteCategoryNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WasteCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String  handleWasteCategoryNotFound(WasteCategoryNotFoundException e){
        return e.getMessage();
    }
}
