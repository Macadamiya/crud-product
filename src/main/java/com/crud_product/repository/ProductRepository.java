package com.crud_product.repository;

import com.crud_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


// e uma interface do SpringBoot que indica que podemos fazer CRUD (post, get, put, delete)
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
    Page<Product> findByModeloContainingOrFornecedorContainingOrDescricaoContainingOrCategoriaContainingOrMarcaContaining(String modelo, String fornecedor, String descricao, String categoria, String marca, Pageable pageable);
}
