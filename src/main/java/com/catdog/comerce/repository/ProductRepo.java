package com.catdog.comerce.repository;

import com.catdog.comerce.entity.Brand;
import com.catdog.comerce.entity.Category;
import com.catdog.comerce.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepo extends RepoGeneric<Product,Long> {
    Optional<Product> findByNameAndCategoryAndBrand(String name, Brand brand, Category category);
}
