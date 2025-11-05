
# 🧮 Projeto CRUD de Produtos em Java

Este projeto é um **CRUD (Create, Read, Update, Delete)** desenvolvido em **Java**, com integração ao **banco de dados MySQL** utilizando **JDBC**.  
O sistema permite **cadastrar, listar, atualizar e excluir produtos**, simulando um pequeno gerenciamento de estoque via terminal (console).

---

## 🚀 Tecnologias utilizadas

- ☕ Java 21
- 🗄️ MySQL
- 🔌 JDBC (Java Database Connectivity)
- 🧰 IntelliJ IDEA

---

```
## 🗂️Estrutura do projeto

ProjetoDB/
|--src/
|   |----application/
|   |          |____ProdutoMain.java
|   |----connectionFactory/
|   |          |____Conexao.java
|   |----DAO/
|   |     |____ProdutoDAO.java
|   |____entity/
|         |____Produto.java
|   
|---- .gitignore
|______README.md



  ```


## 🗄️ Estrutura do Banco de Dados

**Banco:** cadastro_produtos

**Tabela:** produtos

```sql
CREATE DATABASE cadastro_produtos;

USE cadastro_produtos;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT
);
