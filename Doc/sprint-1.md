# 🏁 Sprint 1 - FieldOpsManager  
📅 Período: 28/07/2025 a 10/08/2025  
✅ **Status: Concluída com sucesso**  
🚀 **Sprint 2 iniciada antecipadamente**

---

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
  - `service` – camada de regras de negócio
  - `util` – utilitários do sistema
  - `App` – ponto de entrada para testes

---

## 🧱 Entidades Criadas

### ✅ Modelagem JPA
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

---

## ✅ DAO, Controller e Service

| Entidade     | DAO                    | Controller              | Service                 |
|--------------|------------------------|--------------------------|--------------------------|
| Cidade       | ✅ `CidadeDao.java`       | ✅ `CidadeController.java`  | ✅ `CidadeService.java`     |
| Cliente      | ✅ `ClienteDao.java`      | ✅ `ClienteController.java` | ✅ `ClienteService.java`    |
| Colaborador  | ✅ `ColaboradorDao.java`  | ✅ `ColaboradorController.java` | ✅ `ColaboradorService.java` |
| Contato      | ✅ `ContatoDao.java`      | ✅ `ContatoController.java` | ✅ `ContatoService.java`    |
| Endereco     | ✅ `EnderecoDao.java`     | ✅ `EnderecoController.java` | ✅ `EnderecoService.java`   |
| Equipamento  | ✅ `EquipamentoDao.java`  | ✅ `EquipamentoController.java` | ✅ `EquipamentoService.java` |
| Estado       | ✅ `EstadoDao.java`       | ✅ `EstadoController.java`  | ✅ `EstadoService.java`     |
| OS           | ✅ `OSDao.java`           | ✅ `OSController.java`      | ✅ `OSService.java`         |
| Scripts      | ✅ `ScriptDao.java`       | ✅ `ScriptController.java`  | ✅ `ScriptService.java`     |

---

## 🔁 Relacionamentos JPA
- Uso de `@ManyToOne`, `@OneToMany` para relacionar entidades como `endereço` com `Cidade`, `Contato`, etc.

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

## ✅ Front insert colaborador Implementado

- `ColaboradorView.java`:
  - Camada de exibição para inserção de colaboradores via controller

---

## ✅ Todos os módulos concluídos

- Todas as entidades possuem DAO, Controller e Service
- Camadas bem organizadas e testadas
- Preparação completa para integração da camada visual

---

## 🔒 Itens de Segurança

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

- ✅ Início antecipado da Sprint 2
- Iniciar desenvolvimento da interface gráfica com JavaFX
- Adicionar autenticação de usuários
- Considerar uso de MongoDB para logs/auditoria
