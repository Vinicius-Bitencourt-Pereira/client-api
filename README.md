# client-api

# Sobre o projeto

O objetivo deste projeto foi o desenvolvimento de um CRUD de clientes, para consolidar o conhecimento das tecnologias utilizadas.

# Tecnologias utilizadas

## Back end
- Java 11
- Spring boot 2.3.4
- Spring Web
- Spring Data JPA
- H2 database

## Front end*
- Postman

# Como executar o projeto

## Pré-requisitos: 
- JDK 11
- Spring boot 2.3.4
- Postman (para testar as requisições).

``` bash
# clonar repositório
git clone git@github.com:Vinicius-Bitencourt-Pereira/client-api.git

# Importar o projeto na IDE desejada

# Startar o projeto

# Importar esta coleção no postman
https://drive.google.com/file/d/13uwes0Odn2Bb0sygfV243Kf-H--xGYYt/view?usp=sharing

# Testar os endpoints
```
### IDE utilizada no desenvolvimento da api 
https://spring.io/tools


## Endpoints da api

 * Buscar todos os clientes (paginado)
  ```java
  [GET] /clients
  ```
  * Buscar cliente por id
  ```java
  [GET] /clients/{id}
  ```
  * Criar um novo cliente
  ```java
  [POST] /clients
  ```
  * Atualizar um cliente
  ```java
  [PUT] /clients/{id}
  ```
  * Deletar um cliente
  ```java
  [DELETE] /clients/{id}
  ```

   ### Dados para criar e atualizar um cliente
  ```json
  {
    "name": "New name",
    "cpf": "99999999999",
    "income": 15000.0,
    "birthDate": "2023-03-07T21:21:00Z",
    "children": 1
    }
  ```