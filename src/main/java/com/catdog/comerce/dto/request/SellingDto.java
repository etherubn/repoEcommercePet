package com.catdog.comerce.dto.request;

import com.catdog.comerce.entity.SellingProduct;
import com.catdog.comerce.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellingDto implements Serializable {
    @JsonProperty("id")
    private Long idSelling;

    @NotNull(message = "Selling need products")
    @JsonProperty("products")
    private List<SellingProductDto> sellingProducts;


    //TODO: Falta estados de compra

    @NotNull(message = "Selling needs a user")
    private UserDto user;
}
