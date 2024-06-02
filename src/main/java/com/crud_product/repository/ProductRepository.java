package com.crud_product.repository;

import com.crud_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;


//e uma interface do SpringBoot que indica que podemos fazer CRUD (post, get, put, delete)
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    //funcao para listar todos.
    List<Product> findByModeloContainingOrFornecedorContainingOrDescricaoContainingOrCategoriaContainingOrMarcaContaining( String modelo, String fornecedor, String descricao, String categoria, String marca);
}