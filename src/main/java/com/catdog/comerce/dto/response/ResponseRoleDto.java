package com.catdog.comerce.dto.response;

import com.catdog.comerce.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseRoleDto {
    @JsonProperty("id")
    private Long idRole;
    private RoleType type;
}
