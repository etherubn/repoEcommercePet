package com.catdog.comerce.entity;

import com.catdog.comerce.enums.AccesoryType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

//TODO ver como será la herencia
public class Accesory {
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false,unique = true)
    private AccesoryType type;
    @NotNull
    private boolean hypoallergenic;
}
