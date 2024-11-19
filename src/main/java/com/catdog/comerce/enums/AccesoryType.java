package com.catdog.comerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccesoryType {
    CLEANING("cleaning"),
    TOY("toy");

    private String value;

    AccesoryType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }

    @JsonCreator
    public static AccesoryType fromValue(String value){
        if (value!=null){
            for (AccesoryType categoryType:AccesoryType.values()){
                if (value.equals(categoryType.getValue())){
                    return categoryType;
                }
            }
        }

        throw new IllegalArgumentException("Valor no se encuentra dentro de los valores permitidos: "+value);
    }
}
