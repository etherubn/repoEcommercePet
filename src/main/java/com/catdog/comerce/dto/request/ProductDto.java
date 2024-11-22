package com.catdog.comerce.dto.request;

import com.catdog.comerce.enums.PetType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto implements Serializable {

    private Long idProduct;

    @Size(min = 2,max = 30,message = "Product's name needs to contain min 2 and max 30 characters")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @Positive(message = "stock must be greater than 0")
    private Integer stock;

    @NotBlank(message = "Description is required")
    @Size(max = 50,message = "Description allowed max 50 characters")
    private String description;

    @NotNull(message = "category is required")
    private CategoryDto category;

    @NotNull(message = "brand is required")
    private BrandDto brand;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type cant be null")
    private PetType type;



}
