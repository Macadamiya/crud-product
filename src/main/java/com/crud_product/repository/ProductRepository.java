package com.crud_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud_product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}