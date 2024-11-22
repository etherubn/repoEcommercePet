package com.catdog.comerce.dto.response;


import com.catdog.comerce.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUserDto {
    private Long idUser;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String username;
    private ResponseRoleDto role;
}
