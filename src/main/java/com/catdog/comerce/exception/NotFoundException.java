package com.catdog.comerce.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String entity, Long id) {
        super(String.format("Resource not found: %s with id %d",entity,id));
    }
}
