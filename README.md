# 🚀 Spring Boot API - Cadastro de Pessoas e Clientes

Este projeto é uma **API RESTful desenvolvida com Spring Boot**, integrando banco de dados MySQL, validação de dados com `@Valid` e tratamento global de erros. O objetivo é demonstrar um CRUD completo com regras de negócio, ordenação, filtros e boas práticas de desenvolvimento backend.

---

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Jakarta Validation (Bean Validation)
- MySQL
- Maven
- VS Code + Thunder Client

---

## 📂 Estrutura do Projeto

```
src/main/java/br/com/java/api
├── controle       -> Controllers (endpoints)
├── modelo         -> Entidades (Pessoa, Cliente)
├── repositorio    -> Repositórios JPA
├── servico        -> Lógica de negócio
├── valida         -> Tratamento global de exceções
```

---

## 🔐 application.properties (trecho)

```properties
spring.application.name=api
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/api_spring
spring.datasource.username=root
spring.datasource.password=******
```

---

## 🔢 Endpoints

### ✅ Pessoa

- `GET    /api`                 - Listar todas as pessoas
- `POST   /api`                 - Cadastrar nova pessoa
- `PUT    /api/editar`          - Editar dados de uma pessoa
- `DELETE /api/{codigo}`        - Remover pessoa por código
- `GET    /api/{codigo}`        - Buscar pessoa por código
- `GET    /api/idadeMaiorIgual` - Pessoas com idade >= 40
- `GET    /api/somaIdade`       - Soma total das idades
- `GET    /api/iniciaCom`       - Pessoas cujo nome inicia com "m"
- `GET    /api/ordenarNomes`    - Lista de nomes ordenados alfabeticamente

### ✅ Cliente

- `POST /cliente` - Cadastrar cliente com validação

---

## 📊 Exemplo de Validação

Requisição com dados inválidos:
```json
{
  "nome": "",
  "email": "jair"
}
```

Resposta:
```json
{
  "nome": "O campo nome é obrigatório",
  "email": "O campo email é obrigatório"
}
```

Validações tratadas com `@Valid` e `@ControllerAdvice` pela classe `Validacao.java`.

---

## 📅 Banco de Dados (MySQL)

### Tabela: `pessoas`
| Campo  | Tipo        |
|--------|-------------|
| codigo | INT (PK)    |
| nome   | VARCHAR(255)|
| idade  | INT         |

### Tabela: `clientes`
| Campo  | Tipo        |
|--------|-------------|
| codigo | INT (PK)    |
| nome   | VARCHAR(255)|
| email  | VARCHAR(255)|

---

## 📁 Prints da API em uso

### Cadastro de Pessoa
![Cadastro Pessoa](./prints/cadastro-pessoa.png)

### Lista Ordenada por Nome
![Ordenar Nomes](./prints/ordenar-nomes.png)

### Validação de Erros
![Erro de Validação](./prints/erro-validacao-cliente.png)

### Dados no Banco
![Banco MySQL](./prints/tabela-pessoas.png)

> ✉️ Coloque os prints na pasta `/prints` do seu repositório.

---

## 📅 Como Rodar o Projeto

```bash
# Clonar o repositório
https://github.com/Wendersonjose/springboot-api-pessoas-clientes.git

# Acessar a pasta do projeto
cd springboot-api-pessoas-clientes

# Configurar o application.properties com seu MySQL

# Rodar a aplicação
./mvnw spring-boot:run
```

---

## 👤 Autor

Desenvolvido por [Wenderson José](https://github.com/Wendersonjose)
Entre em contato para feedbacks e colaborações!

---

## ✉️ Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.


