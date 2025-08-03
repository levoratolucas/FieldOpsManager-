# 📋 Sprint 1 - Julho/Agosto 2025

## Objetivo
Estabelecer a base do projeto `FieldOpsManager`, com foco em estruturação de código, persistência de dados e modelagem inicial.

---

## ✅ Entregas concluídas

### Estruturação de Projeto
- Projeto iniciado com Java puro e Gradle
- Criação da estrutura de pacotes:
  - `com.osapp.model`
  - `com.osapp.dao`
  - `com.osapp.controller`
  - `com.osapp.util`
  - `com.osapp.App` (classe principal)

### Modelagem de Dados
- Entidade `Colaborador` com atributos: `id`, `name`, `cargo`
- Entidade `OS` (ordem de serviço) com relacionamento com `Cliente` e `Colaborador`
- Entidade `Scripts` com relacionamentos para `Equipamento` e `OS`
- Mapeamento JPA completo com `@Entity`, `@Id`, `@GeneratedValue`, `@ManyToOne`, `@Lob`, `@Table`

### Persistência de Dados
- `ColaboradorDao` criado com métodos:
  - `salvar(Colaborador)`
  - `listarTodos()`
  - `buscarPorId(Long)`
  - `deletar(Long)`
- Uso do `EntityManager` para operações transacionais
- Transações gerenciadas com `try/catch/finally` e rollback automático em caso de erro

### Lógica de Negócio
- `ColaboradorController` criado para isolar regras de negócio
- Métodos: `adicionarColaborador()` e `listarColaboradores()`
- Injeção de `EntityManager` por parâmetro para maior flexibilidade

### Testes
- Classe `App.java` usada como ponto de entrada
- Inserção e listagem de colaboradores testada via terminal

---

## 📌 Considerações
- Projeto avançando conforme cronograma inicial
- Próxima etapa incluirá mais entidades (`Cliente`, `Equipamento`, etc.), autenticação básica e início da interface JavaFX

---

Lucas Levorato — Julho/Agosto 2025
