package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

public class WasteCategoryNotFoundException extends RuntimeException{
     public WasteCategoryNotFoundException(Long id){
        super("Could not find category with this id " + id);
    }
}
