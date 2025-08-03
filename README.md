# 🏁 Sprint 1 - FieldOpsManager  
📅 Período: 28/07/2025 a 10/08/2025

## 🎯 Objetivo da Sprint
Estabelecer a fundação do projeto FieldOpsManager, com foco em modelagem das entidades principais, estrutura modular por camadas e persistência de dados via JPA/Hibernate. A sprint visa garantir o funcionamento básico de cadastro e leitura no banco de dados, além de definir uma base sólida para as próximas fases.

---

## 📦 Entregas da Sprint

### ✅ Estrutura do Projeto
- Projeto configurado no VSCode
- Organização de pacotes:
  - `model` – entidades JPA
  - `dao` – acesso a dados (Data Access Object)
  - `controller` – camada de lógica de negócio
  - `util` – utilitários do sistema
  - `App` – ponto de entrada para testes

---

## 🧱 Entidades Criadas

### Modelagem JPA
Todas as entidades principais foram criadas com anotações JPA:

- [x] Cidade
- [x] Cliente
- [x] Colaborador
- [x] Contato
- [x] Endereco
- [x] Equipamento
- [x] Estado
- [x] OS
- [x] Scripts

### DAO e Controller

| Entidade     | DAO         | Controller   |
|--------------|-------------|--------------|
| Cidade       | ❌           | ❌            |
| Cliente      | ❌           | ❌            |
| Colaborador  | ✅ `ColaboradorDao.java` | ✅ `ColaboradorController.java` |
| Contato      | ❌           | ❌            |
| Endereco     | ❌           | ❌            |
| Equipamento  | ❌           | ❌            |
| Estado       | ❌           | ❌            |
| OS           | ❌           | ❌            |
| Scripts      | ❌           | ❌            |

---

## 🔁 Relacionamentos JPA
- Uso de `@ManyToOne`, `@OneToMany` para relacionar entidades como `Colaborador` com `Cidade`, `Contato`, etc.

---

## ✅ DAO Funcional

- `ColaboradorDao.java`:
  - `salvar(Colaborador)`
  - `listarTodos()`
  - `buscarPorId(Long)`
  - `remover(Long)`
- Testado com persistência real via terminal

---

## ✅ Controller Implementado

- `ColaboradorController.java`:
  - Camada de lógica de negócio para manipulação de dados via DAO

---

## 🟡 Em Progresso

- DAO e Controller das demais entidades
- Testes e integração com as outras entidades do sistema

---

## ⚠️ Itens de Segurança

- Credenciais e arquivos sensíveis **não estão versionados**
- Informações como URL, usuário e senha do banco ficam no `config.properties` (fora do Git)

---

## 📌 Observações

- Persistência configurada via `persistence.xml`
- Banco de dados: PostgreSQL
- Interface gráfica ainda não iniciada

---

## 🧠 Lições Aprendidas

- Separar camadas melhora a manutenibilidade
- Estrutura modular ajuda na escalabilidade do projeto
- A prática com JPA reforçou o entendimento de mapeamentos e persistência

---

## 📍 Próximos Passos (Sprint 2)

- Iniciar JavaFX (interface gráfica)
- Adicionar autenticação de usuários
- Considerar uso de MongoDB para logs/auditoria

