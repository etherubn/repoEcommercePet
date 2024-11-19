package com.catdog.comerce.entity;


import com.catdog.comerce.enums.PetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//TODO ver como será la herencia
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_product")
    private Long idProduct;

    @NotBlank
    @Size(min = 2,max = 30)
    @Column(nullable = false)
    private String name;

    @PositiveOrZero
    @NotNull
    @Column(nullable = false)
    private Integer stock;

    @NotBlank
    @Size(max = 40)
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_category",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_marca",nullable = false)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PetType petType;
}
