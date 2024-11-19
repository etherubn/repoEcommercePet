package com.catdog.comerce.dto.request;

import com.catdog.comerce.enums.CategoryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto implements Serializable {

    @JsonProperty("id")
    private Long idCategory;

    @NotNull(message = "Type cant be null")
    private CategoryType type;
}
