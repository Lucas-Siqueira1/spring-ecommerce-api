# Spring Ecommerce API

Projeto desenvolvido a partir do modelo de domínio disponibilizado no curso Java COMPLETO da DevSuperior, implementado de forma independente.

---

## Sobre o projeto

O projeto é uma API para um sistema de e-commerce com cadastro de usuários, produtos, categorias e pedidos. Foi desenvolvido com foco em aprender a estruturar um projeto Spring Boot com JPA/Hibernate, organizar as camadas da aplicação e integrar com banco de dados relacional.

---

## Funcionalidades

- CRUD de usuários, produtos, categorias e pedidos
- Relacionamento ManyToMany entre produtos e categorias
- Relacionamento ManyToMany com atributos extras entre pedidos e produtos (OrderItem)
- Relacionamento OneToOne entre pedido e pagamento
- Enum de status do pedido (WAITING_PAYMENT, PAID, SHIPPED, DELIVERED, CANCELED)
- Tratamento global de exceções com respostas padronizadas

---

## Modelo de domínio

```
User  ──< Order >── OrderItem >── Product >── Category
                       │
                    Payment
```

---

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA / Hibernate
- PostgreSQL
- H2 Database (perfil de testes)
- Maven

---

## Como rodar

### Pré-requisitos

- Java 21+
- PostgreSQL instalado e rodando

### Configuração

Crie o banco de dados:

```bash
sudo -u postgres psql -c "CREATE DATABASE springboot_course;"
```

Configure o `application-dev.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_course
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Rodando

```bash
git clone https://github.com/Lucas-Siqueira1/spring-ecommerce-api.git
cd spring-ecommerce-api
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

---

## Endpoints

### Usuários — `/users`

| Método | Rota | Descrição |
|---|---|---|
| GET | `/users` | Lista todos |
| GET | `/users/{id}` | Busca por ID |
| POST | `/users` | Cadastra |
| PUT | `/users/{id}` | Atualiza |
| DELETE | `/users/{id}` | Remove |

```json
{
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "phone": "988888888",
  "password": "123456"
}
```

### Produtos — `/products`

| Método | Rota | Descrição |
|---|---|---|
| GET | `/products` | Lista todos |
| GET | `/products/{id}` | Busca por ID |
| POST | `/products` | Cadastra |
| PUT | `/products/{id}` | Atualiza |
| DELETE | `/products/{id}` | Remove |

```json
{
  "name": "Smart TV",
  "description": "TV 4K 55 polegadas",
  "price": 2190.0,
  "imgUrl": "",
  "categories": [{ "id": 1 }]
}
```

### Categorias — `/categories`

| Método | Rota | Descrição |
|---|---|---|
| GET | `/categories` | Lista todas |
| GET | `/categories/{id}` | Busca por ID |
| POST | `/categories` | Cadastra |
| PUT | `/categories/{id}` | Atualiza |
| DELETE | `/categories/{id}` | Remove |

```json
{
  "name": "Electronics"
}
```

### Pedidos — `/orders`

| Método | Rota | Descrição |
|---|---|---|
| GET | `/orders` | Lista todos |
| GET | `/orders/{id}` | Busca por ID |
| POST | `/orders` | Cria pedido |
| PUT | `/orders/{id}` | Atualiza status |
| DELETE | `/orders/{id}` | Remove |

Para atualizar o status de um pedido:

```json
{
  "orderStatus": 2
}
```

Valores possíveis de `orderStatus`: `1` WAITING_PAYMENT, `2` PAID, `3` SHIPPED, `4` DELIVERED, `5` CANCELED.

---

## Estrutura do projeto

```
src/main/java/com/lucas/spring_ecommerce_api/
├── config/
├── entities/
│   ├── enums/
│   └── pk/
├── repository/
├── resources/
│   └── exceptions/
└── services/
    └── exceptions/
```

---

## Autor

**Lucas Siqueira** — [github.com/Lucas-Siqueira1](https://github.com/Lucas-Siqueira1)