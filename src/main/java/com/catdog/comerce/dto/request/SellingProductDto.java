package com.catdog.comerce.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellingProductDto implements Serializable {
    private Long idSellingProduct;

    @NotNull(message = "Product needs quantity")
    @Positive(message = "Quantity be must positive")
    private Integer quantity;

    @NotNull(message = "Selling needs a product")
    private ProductDto product;
}
