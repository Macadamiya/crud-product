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
    - qtdeEstoque: Integer
    - fornecedor: String
    - marca: String
    - modelo: String
    - dataCriacao: LocalDateTime
    - ultimaEdicao: LocalDateTime

#### Repositório

- findByModeloContainingOrFornecedorContainingOrDescricaoContainingOrCategoriaContainingOrMarcaContaining
    - Parâmetros: String modelo, String fornecedor, String descricao, String categoria, String marca

#### Serviço

- ProductService
    - saveProduct
    - getAllProducts
    - getProductById
    - updateProduct
    - deleteProduct
    - getProductsBySearch

#### Controlador

- ProdutoController
    - createProduct
    - getProducts
    - getProductById
    - updateProduct
    - deleteProduct

[ProdutoController](src/main/java/com/crud_product/controller/ProductController.java)

#### Paginação

Usando o modulo de paginação do Spring Data JPA. Empacotando a função de paginação em uma função de util, para ser
reutilizada em outros serviços.

[Função de Paginação](src/main/java/com/crud_product/util/Pagination.java)

#### Cors Configuration

Configuração de CORS para permitir requisições de qualquer origem.

[Configuração de CORS](src/main/java/com/crud_product/config/CorsConfig.java)





