package com.catdog.comerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseBrandDto {
    @JsonProperty("id")
    private Long idBrand;
    private String name;
}
