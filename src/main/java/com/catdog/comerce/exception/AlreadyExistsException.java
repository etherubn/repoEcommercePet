package com.catdog.comerce.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String entity,String field,String value) {
        super(String.format("Value already exist: entity - %s - field %s - value '%s'",entity,field,value));
    }
}
