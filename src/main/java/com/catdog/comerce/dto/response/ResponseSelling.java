package com.catdog.comerce.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSelling {

    private Long idSelling;
    private LocalDateTime creationSelling;
    private ResponseUserSellingDto responseUserSellingDto;
   @JsonProperty("products")
    private List<ResponseProductSellingDto> responseProductSellingDtos;
    private BigDecimal total;

}
