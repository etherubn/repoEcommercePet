package com.catdog.comerce.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ResponseSelling {

    private Long idSelling;
    private LocalDateTime creationSelling;
    private ResponseUserSellingDto responseUserSellingDto;
   @JsonProperty("products")
    private List<ResponseProductSellingDto> responseProductSellingDtos;
    private BigDecimal total;

}
