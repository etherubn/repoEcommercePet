package com.catdog.comerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProductSellingDto {
    private Long idProduct;
    private String product;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
}
