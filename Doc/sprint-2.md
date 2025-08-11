# 🏁 Sprint 2 - FieldOpsManager  
📅 Período: 13/08/2025 a 26/08/2025  
📌 **Status: Em andamento**

---

## 🎯 Objetivo da Sprint  
Dar início ao desenvolvimento da interface gráfica do FieldOpsManager utilizando JavaFX, com telas para gestão das principais entidades (Colaborador, Cliente, Cidade, Estado, Equipamento e Ordens de Serviço), além de uma tela Home para navegação central. Também visa implementar funções e interfaces polimórficas para operações genéricas e reutilizáveis, como listagem de dados.

---

## 📦 Entregas da Sprint  

### 🖥 Interface Gráfica  
- Tela Home com botões para navegação entre:  
  - Colaborador  
  - Cliente  
  - Cidade  
  - Estado  
  - Equipamento  
  - Ordens de Serviço  

- Telas para cada entidade (Colaborador, Cliente, Cidade, Estado, Equipamento, OS) com funcionalidades:  
  - Listar  
  - Adicionar  
  - Editar  
  - Excluir  
  - Retornar para Home  

### 🧩 Componentes Reutilizáveis  
- Implementação da interface `FieldOpsListable` com método para listagem genérica de entidades  
- Criação de funções genéricas para exibição de listas utilizando polimorfismo  
- Navbar dinâmica para navegação contextual entre telas, reaproveitada em todas as views  

### 🔄 Integração Backend  
- Conexão das telas JavaFX com as camadas Controller e Service existentes da Sprint 1  
- Operações CRUD realizadas diretamente no banco via JPA/Hibernate  
- Validação de dados na interface antes da persistência  

---

## 🔒 Itens de Segurança  
- Garantia de fluxos seguros para navegação e edição de dados  
- Proteção contra exposição de dados sensíveis na interface  

---

## 📌 Observações  
- Interface desenvolvida com JavaFX usando BorderPane, VBox, HBox e componentes reutilizáveis  
- Expansão dos métodos auxiliares em `Tools` para criação dinâmica de tabelas e formulários genéricos  
- Possível criação futura de camada DTO para separação clara entre exibição e persistência  

---

## 🧠 Lições Esperadas  
- Aprofundar o uso do JavaFX para interfaces modulares e reutilizáveis  
- Fortalecer o uso de polimorfismo para reduzir duplicidade de código  
- Consolidar a arquitetura em camadas integrando frontend e backend  

---

## 📍 Prazo  
- Duração: 14 dias  
- Início: 13/08/2025  
- Término previsto: 26/08/2025  

