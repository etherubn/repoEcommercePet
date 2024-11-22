package com.catdog.comerce.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable {
    private Long idUser;

    @NotBlank(message = "Name is required")
    @Size(max = 30,message = "Name needs 30 characters")
    private String name;
    @NotBlank(message ="Last name is required")
    @Size(max = 30,message = "Last name needs 30 characters")
    private String lastName;
    @NotBlank(message = "Dni is required")
    @Size(min = 8,max = 8,message = "Dno needs only 8 characters")
    private String dni;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 80)
    private String password;

    private RoleDto role;

}
