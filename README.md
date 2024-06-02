# CRUD-PRODUCT

## Descrição

Projeto de CRUD de produtos utilizando Spring Boot(Java) e Angular(Typescript).

## Tecnologias

### Spring Boot

- Java 17
- Spring Boot 3.3.0
- Spring Data JPA
- Spring Web
- MySQL

### Angular

- Angular 15.2.0
- Boostrap 5.3.0
- FormBuilder
- HttpClient
- RxJS

## Desenvolvimento

### Spring Boot

#### Documento de API

O documento de API foi feito utilizando o Postman e está disponível no link abaixo:

[Documentação da API](https://documenter.getpostman.com/view/19421762/2sA3Qv8Amm)

#### Modelo

- Produto
    - id: Long
    - descricao: String
    - preco: Double
    - categoria: String
    - estoque: Integer
    - fornecedor: String
    - marca: String
    - modelo: String
    - dataCriacao: LocalDateTime
    - ultimaEdicao: LocalDateTime

#### Repositório

- ProdutoRepository
  ...(Esperando Mauro terminar)

#### Serviço

- ProductService
    - saveProduct
    - getAllProducts
    - getProductById
    - updateProduct
    - deleteProduct
    - ...(Esperando Mauro terminar)

#### Controlador

- ProdutoController
    - createProduct
    - getProducts
    - getProductById
    - updateProduct
    - deleteProduct



