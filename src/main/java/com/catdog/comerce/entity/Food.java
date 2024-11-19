package com.catdog.comerce.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//TODO ver como será la herencia
public class Food {

    @NotNull
    private boolean refrigeration;

    //TODO : Ver validacion para 2 decimales
    @Positive
    private double peso;
}
