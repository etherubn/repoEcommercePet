package com.catdog.comerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @EqualsAndHashCode.Include
    private Long idUser;

    @NotBlank
    @Size(max = 30)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotBlank
    @Column(unique = true,nullable = false)
    @Size(min = 8,max = 8)
    private String dni;

    @Email
    @NotBlank
    @Column(unique = true,nullable = false)
    private String email;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String username;

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false)
    private String password;

    @Column(updatable = false,nullable = false,name = "creation_date")
    private LocalDateTime creationDate;

    @PrePersist
    public void setBeforePersist(){
        creationDate = LocalDateTime.now();
    }

    //Todo
    //Debeiniciar en 0
    //luego de realizar la compra aumentar
    @PositiveOrZero
    @Column(name = "purchase_amount")
    private Integer purchaseAmount=0;

    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false)
    private Role role;
}
