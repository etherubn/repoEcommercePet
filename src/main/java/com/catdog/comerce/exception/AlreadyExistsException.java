package com.catdog.comerce.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String entity,String value) {
        super(String.format("Valor ya existe: %s para el valor '%s'",entity,value));
    }
}
