package com.catdog.comerce.dto.response;

import com.catdog.comerce.enums.CategoryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseCategoryDto {
    @JsonProperty("id")
    private Long idCategory;
    private CategoryType type;
}
