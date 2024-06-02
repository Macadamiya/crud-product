package com.crud_product.service;

import com.crud_product.exception.ResourceNotFoundException;
import com.crud_product.model.Product;
import com.crud_product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// terceiro passo, cria as funcionalidades da api (service)
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // cria funcao de salvar dado em api (save) - atualizado
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //cria funcao get (findAll) - atualizado
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // getall
    public List<Product> getProductsBySearch(String search) {
        return productRepository.findByModeloContainingOrFornecedorContainingOrDescricaoContainingOrCategoriaContainingOrMarcaContaining(search, search, search, search, search);
    }

    //verifica se existe aquele id, se tiver, ele retorna o dado, caso nao, ele retorna resolutionException -- atualizado
    public Optional<Product> getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return Optional.of(product);
    }

    //cria funcao de atualizar dado (save)  -- atualizado
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        product.setDescricao(productDetails.getDescricao());
        product.setPreco(productDetails.getPreco());
        product.setCategoria(productDetails.getCategoria());
        product.setQtde_estoque(productDetails.getQtde_estoque());
        product.setFornecedor(productDetails.getFornecedor());
        product.setMarca(productDetails.getMarca());
        product.setModelo(productDetails.getModelo());
        product.setDataCriacao(productDetails.getDataCriacao());
        product.setUltimaEdicao(productDetails.getUltimaEdicao());
        return productRepository.save(product);
    }

    //funcao deletar - atualizado
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        productRepository.delete(product);
    }


}
