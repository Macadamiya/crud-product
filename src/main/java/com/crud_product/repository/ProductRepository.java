package com.crud_product.repository;

import com.crud_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


//e uma interface do SpringBoot que indica que podemos fazer CRUD (post, get, put, delete)
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDescricaoContaining(String descricao);
}
