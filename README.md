# FieldOpsManager

**FieldOpsManager** é uma aplicação Java de gestão de ordens de serviço desenvolvida com o objetivo de registrar e acompanhar as atividades realizadas por técnicos de campo na área de dados e redes corporativas.

Este projeto é parte de um estudo pessoal com foco em:

- Boas práticas com Java moderno  
- Arquitetura limpa e modular  
- Uso de ORM com JPA/Hibernate  
- Integração com bancos de dados (PostgreSQL e MongoDB)  
- Interface gráfica com JavaFX  
- Autenticação e permissões de usuários  

---

## 🚀 Funcionalidades (em progresso)

- [x] Modelagem de dados orientada a objetos  
- [x] Projeto Java com estrutura modular (camadas: `model`, `dao`, `controller`, `util`)  
- [x] CRUD funcional via terminal com persistência em banco (JPA/Hibernate)  
- [x] Relacionamentos entre entidades  
- [x] Interface gráfica com JavaFX  
- [ ] Autenticação de usuários  
- [ ] Logs e histórico de ações (MongoDB)  
- [ ] Relatórios e filtros de ordens de serviço  

---

## 🧱 Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- MongoDB *(futuro)*  
- JavaFX *(interface gráfica)*  
- Gradle *(build)*  
- Lombok *(redução de boilerplate)*  

---

## 📚 Objetivo do projeto

> Desenvolver um sistema completo, realista e funcional que permita acompanhar a rotina de trabalho de um técnico de campo. A aplicação foi planejada para explorar conceitos intermediários e avançados da linguagem Java, incluindo persistência, orientação a objetos, uso de frameworks e arquitetura limpa.

---

## ✅ Progresso - Sprint 1 (Julho/Agosto 2025)

- Estrutura inicial do projeto criada no VSCode  
- Organização de pacotes: `model`, `dao`, `controller`, `util`, `App` ,`service` ,`view`
- Entidades criadas: `Cidade`, `Cliente`, `Colaborador`, `Contato`, `Endereco`, `Equipamento`, `Estado`, `OS`, `Scripts`  
- Relacionamentos JPA definidos (`@ManyToOne`, `@OneToMany`, etc.)  
- DAO criado para `Colaborador,Estado` com persistência, listagem, busca e remoção  
- Controller para `Colaborador` com lógica de negócio separada  
- Testes manuais no terminal com criação e leitura de dados via `App`  
- Layout basico com javaFX `ColaboradorView` (Sprint 2 antecipado)

---

## 🧠 Autor

Desenvolvido por **Lucas Matheus Levorato Santos** ([@levoratech](mailto:lucaslevorato@levoratech.com)) como parte do seu aprendizado e evolução como desenvolvedor Java.  
Este projeto é documentado por sprints quinzenais e pensado como um case de portfólio técnico.

---

## 📝 Licença

Este projeto está licenciado sob a **Levoratech License** – uso pessoal, educacional e profissional permitido com créditos ao autor.
