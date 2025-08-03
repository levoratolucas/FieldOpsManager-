# Documento de Arquitetura do Banco de Dados  
## Projeto: FieldOpsManager

---

## Visão Geral

O sistema **FieldOpsManager** tem como objetivo gerenciar as atividades operacionais de um técnico de campo, incluindo a gestão de ordens de serviço (OS), clientes, equipamentos utilizados e scripts técnicos aplicados durante as operações.

Este documento apresenta a modelagem de dados relacional que servirá como base para implementação da aplicação, utilizando **PostgreSQL** como banco relacional principal e futura integração com um banco NoSQL como **MongoDB**.

---

## Entidades e Atributos

### 1. Colaborador  
Representa o técnico responsável pela execução das ordens de serviço.

| Campo | Tipo          | Restrições          |
|-------|---------------|---------------------|
| id    | INT           | PK, AUTO_INCREMENT  |
| re    | VARCHAR(20)   | NOT NULL            |
| nome  | VARCHAR(100)  | NOT NULL            |

---

### 2. Cliente  
Armazena informações básicas dos clientes atendidos.

| Campo       | Tipo          | Restrições                 |
|-------------|---------------|----------------------------|
| id          | INT           | PK, AUTO_INCREMENT         |
| nome        | VARCHAR(100)  | NOT NULL                   |
| endereco_id | INT           | FK → endereco(id)          |

---

### 3. Contato  
Informações de contato associadas a um cliente.

| Campo      | Tipo          | Restrições                 |
|------------|---------------|----------------------------|
| id         | INT           | PK, AUTO_INCREMENT         |
| nome       | VARCHAR(100)  | NOT NULL                   |
| telefone   | VARCHAR(20)   | NOT NULL                   |
| cliente_id | INT           | FK → cliente(id)           |

---

### 4. Endereço  
Endereço detalhado do cliente.

| Campo     | Tipo          | Restrições                 |
|-----------|---------------|----------------------------|
| id        | INT           | PK, AUTO_INCREMENT         |
| rua       | VARCHAR(100)  | NOT NULL                   |
| bairro    | VARCHAR(100)  |                            |
| numero    | VARCHAR(10)   |                            |
| cidade_id | INT           | FK → cidade(id)            |

---

### 5. Cidade  
Cidades disponíveis no cadastro.

| Campo     | Tipo          | Restrições                 |
|-----------|---------------|----------------------------|
| id        | INT           | PK, AUTO_INCREMENT         |
| nome      | VARCHAR(100)  | NOT NULL                   |
| estado_id | INT           | FK → estado(id)            |

---

### 6. Estado  
Tabela auxiliar para normalização dos dados de localização.

| Campo | Tipo          | Restrições                  |
|-------|---------------|-----------------------------|
| id    | INT           | PK, AUTO_INCREMENT          |
| nome  | VARCHAR(100)  | NOT NULL                    |
| sigla | VARCHAR(2)    | NOT NULL (ex: PR, SP)       |

---

### 7. Equipamentos  
Lista dos equipamentos que podem ser usados em campo.

| Campo | Tipo          | Restrições          |
|-------|---------------|---------------------|
| id    | INT           | PK, AUTO_INCREMENT  |
| nome  | VARCHAR(50)   | NOT NULL            |
| tipo  | VARCHAR(50)   |                     |

---

### 8. Ordem de Serviço (OS)  
Representa uma atividade de campo atribuída a um colaborador e cliente.

| Campo          | Tipo  | Restrições           |
|----------------|-------|----------------------|
| id             | INT   | PK, AUTO_INCREMENT   |
| cliente_id     | INT   | FK → cliente(id)     |
| colaborador_id | INT   | FK → colaborador(id) |
| comentarios    | TEXT  |                      |

---

### 9. Scripts  
Scripts utilizados na execução de uma OS com um equipamento específico.

| Campo         | Tipo          | Restrições           |
|---------------|---------------|----------------------|
| id            | INT           | PK, AUTO_INCREMENT   |
| equipamento_id| INT           | FK → equipamento(id) |
| os_id         | INT           | FK → os(id)          |
| script        | TEXT          | NOT NULL             |
| comentarios   | TEXT          |                      |

---

## Relacionamentos

- Estado 1:N Cidade  
- Cidade 1:N Endereço  
- Endereço 1:N Cliente  
- Cliente 1:N Contato  
- Cliente 1:N Ordem de Serviço  
- Colaborador 1:N Ordem de Serviço  
- OS 1:N Scripts  
- Equipamento 1:N Scripts  

---

## Regras de Negócio

- Cada cliente possui um endereço único, mas pode ter múltiplos contatos.  
- Cada OS está associada a um cliente e um colaborador.  
- Vários scripts podem ser associados a uma única OS.  
- Equipamentos são reutilizáveis entre diferentes OS e scripts.  
- Scripts devem conter informações técnicas utilizadas em campo para rastreabilidade.
