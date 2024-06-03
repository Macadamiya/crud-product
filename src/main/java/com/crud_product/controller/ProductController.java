package com.crud_product.controller;

import com.crud_product.exception.ResourceNotFoundException;
import com.crud_product.model.Product;
import com.crud_product.service.ProductService;
import com.crud_product.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products") //define link da api
public class ProductController {

    //injeção de dependencia
    @Autowired
    private ProductService productService;

    @Value("${base.url:http://localhost:8080/api/products}")
    private String baseUrl;

    //realiza as funcoes, criando uma açao ao servidor
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public ResponseEntity<?> getProducts(@RequestParam(required = false) String search,
                                         @RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Product> productPage;

        if (search != null) {
            productPage = productService.getProductsBySearch(search, pageable);
        } else {
            productPage = productService.getProducts(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("pagination", Pagination.getPaginationResponse(productPage, baseUrl, page, size));
        response.put("results", productPage.getContent());

        return ResponseEntity.ok(response);
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
