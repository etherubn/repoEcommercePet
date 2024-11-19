package com.catdog.comerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto implements Serializable {
    //TODO:Ver como poner el DTO para productos
    private Long idProduct;
}
