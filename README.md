# 📦 Spring App - API REST de Produtos e Categorias

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot**, com suporte a documentação interativa via **Swagger**. A API permite o cadastro, listagem, atualização e exclusão de **produtos** vinculados a **categorias**.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.5
  - Spring Web
  - Spring Data JPA
- H2 Database (em memória)
- Swagger / OpenAPI 3 (SpringDoc)
- Jackson (serialização JSON)

---

## 📂 Estrutura de Entidades

### 📁 Categoria
- `id`: Long
- `nome`: String
- `produtos`: List<Produto>

### 📁 Produto
- `id`: Long
- `nome`: String
- `preco`: Double
- `categoria`: Categoria (relacionamento ManyToOne)

---

## 📚 Endpoints

A documentação interativa da API está disponível via Swagger:

📎 Acesse: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

### ✅ Categorias

| Método | Endpoint              | Descrição                    |
|--------|------------------------|------------------------------|
| GET    | `/categorias`          | Listar todas as categorias   |
| GET    | `/categorias/{id}`     | Buscar categoria por ID      |
| POST   | `/categorias`          | Criar nova categoria         |
| PUT    | `/categorias/{id}`     | Atualizar categoria existente |
| DELETE | `/categorias/{id}`     | Deletar categoria por ID     |

### ✅ Produtos

| Método | Endpoint              | Descrição                    |
|--------|------------------------|------------------------------|
| GET    | `/produtos`            | Listar todos os produtos     |
| GET    | `/produtos/{id}`       | Buscar produto por ID        |
| POST   | `/produtos`            | Criar novo produto           |
| PUT    | `/produtos/{id}`       | Atualizar produto existente  |
| DELETE | `/produtos/{id}`       | Deletar produto por ID       |

---

## 🧪 Exemplos de Requisição

### Criar Categoria (POST `/categorias`)
```json
{
  "nome": "Livros"
}
```

### Criar Produto (POST `/produtos`)
```json
{
  "nome": "Harry Potter",
  "preco": 49.99,
  "categoria": {
    "id": 1
  }
}
```

---

## 🛠 Como Rodar o Projeto

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/spring-app.git
cd spring-app
```

2. **Execute com Maven**
```bash
./mvnw spring-boot:run
```

3. Acesse o Swagger em: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 🧠 Observações Técnicas

- O banco de dados usado é **H2 em memória**.
- A serialização usa `@JsonManagedReference` e `@JsonBackReference` para evitar loops entre Produto e Categoria.
- `@Consumes` e `@Produces` com `application/json` foram adicionados para evitar erros 415 no Swagger UI.

---

Feito com Java por Gabriel Soares
