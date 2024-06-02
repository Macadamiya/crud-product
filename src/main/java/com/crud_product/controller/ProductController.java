package com.crud_product.controller;

import com.crud_product.exception.ResourceNotFoundException;
import com.crud_product.model.Product;
import com.crud_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") //define link da api
public class ProductController {

    //injeção de dependencia
    @Autowired
    private ProductService productService;

    //realiza as funcoes, criando uma açao ao servidor
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // campo de pesquisa
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String search) {
        if (search != null) {
            return productService.getProductsBySearch(search);
        } else {
            return productService.getAllProducts();
        }
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).get();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
