package com.crud_product.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NotNull(message = "A descrição do produto é obrigatória")
    private String descricao;
    private double preco;
    private String categoria;
    private Integer qtdeEstoque;
    private String fornecedor;
    private String marca;
    private String modelo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private LocalDateTime ultimaEdicao;

    //construtor, precisa ser vazio
    public Product() { }


    //funções lifecycle
    @PrePersist
    public void prePersist() {
        LocalDateTime agora = LocalDateTime.now();
        this.dataCriacao = agora;
        this.ultimaEdicao = agora;
    }

    @PreUpdate
    public void preUpdate() {
        this.ultimaEdicao = LocalDateTime.now();
    }

    //access methods
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getQtdeEstoque() {return qtdeEstoque;}
    public void setQtdeEstoque(Integer qtdeEstoque) { this.qtdeEstoque = qtdeEstoque; }

    public String getFornecedor() {return fornecedor;}
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }

    public String getMarca() {return marca;}
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) { this.modelo = modelo; }

    public LocalDateTime getDataCriacao() {return dataCriacao;}
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public LocalDateTime getUltimaEdicao() {return ultimaEdicao;}
    public void setUltimaEdicao(LocalDateTime ultimaEdicao) { this.ultimaEdicao = ultimaEdicao; }
}
