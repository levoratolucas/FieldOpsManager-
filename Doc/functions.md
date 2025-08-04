
# 📘 Tools.java - Documentação de Funções Utilitárias (JavaFX)

Esta classe contém utilitários para a construção de interfaces JavaFX reutilizáveis com foco em layouts modulares e criação dinâmica de botões com ações.

---

## 🔧 Funções Disponíveis

### ✅ `criarBotao(String texto, EventHandler<ActionEvent> acao)`

Cria um botão JavaFX com texto e ação associada.

**Parâmetros:**
- `texto`: Texto a ser exibido no botão.
- `acao`: Função (lambda ou handler) que será executada quando o botão for clicado.

**Retorno:**  
`Button` – Um botão JavaFX pronto para ser adicionado à interface.

**Exemplo:**
```java
Button salvar = Tools.criarBotao("Salvar", e -> System.out.println("Salvando..."));
```

---

### ✅ `criarBotoes(String[] nomes, List<EventHandler<ActionEvent>> acoes)`

Cria uma lista de botões a partir de nomes e ações correspondentes.

**Parâmetros:**
- `nomes`: Array de strings com os textos dos botões.
- `acoes`: Lista de `EventHandler<ActionEvent>` com as ações correspondentes.

**Retorno:**  
`List<Button>` – Lista de botões prontos para uso.

**Observação:**  
Lança `IllegalArgumentException` se o número de nomes e ações for diferente.

**Exemplo:**
```java
String[] nomes = {"Salvar", "Editar", "Excluir"};
List<EventHandler<ActionEvent>> acoes = List.of(
    e -> salvar(),
    e -> editar(),
    e -> excluir()
);

List<Button> botoes = Tools.criarBotoes(nomes, acoes);
```

---

### ✅ `criarHeader(String title, String style, int padding, List<Button> botoes)`

Cria um `HBox` estilizado para o cabeçalho com título e botões alinhados à direita.

**Parâmetros:**
- `title`: Título do cabeçalho.
- `style`: Estilo CSS inline do cabeçalho.
- `padding`: Espaçamento interno (em pixels).
- `botoes`: Lista de botões para adicionar ao cabeçalho.

**Retorno:**  
`HBox` – Componente de cabeçalho pronto para adicionar à interface.

**Exemplo:**
```java
HBox header = Tools.criarHeader("Painel de Usuários", "-fx-background-color: #333;", 10, botoes);
```

---

### ✅ `nav()`

Cria um painel lateral de navegação (`VBox`) com estilo definido.

**Retorno:**  
`VBox` – Painel lateral.

---

### ✅ `workspace()`

Cria um painel principal de conteúdo (`VBox`) com estilo definido.

**Retorno:**  
`VBox` – Painel de conteúdo principal.

---

### ✅ `criarMain(VBox nav, VBox workspace)`

Cria o conteúdo principal (`HBox`) contendo navegação e área de trabalho. O tamanho é ajustável proporcionalmente com base no tamanho da janela.

**Parâmetros:**
- `nav`: Painel lateral.
- `workspace`: Área principal de trabalho.

**Retorno:**  
`HBox` – Layout principal para adicionar ao `Scene`.

---

### ✅ `criarFooter()`

Cria um rodapé estilizado com texto padrão.

**Retorno:**  
`Label` – Componente de rodapé.

---

## 🧪 Exemplo de Uso Geral:

```java
VBox nav = Tools.nav();
VBox workspace = Tools.workspace();

String[] nomes = {"Adicionar", "Editar", "Excluir"};
List<EventHandler<ActionEvent>> acoes = List.of(
    e -> adicionar(),
    e -> editar(),
    e -> excluir()
);
List<Button> botoes = Tools.criarBotoes(nomes, acoes);

HBox header = Tools.criarHeader("Gerenciamento", "-fx-background-color: #2c3e50;", 10, botoes);
HBox main = Tools.criarMain(nav, workspace);
Label footer = Tools.criarFooter();

BorderPane root = new BorderPane();
root.setTop(header);
root.setCenter(main);
root.setBottom(footer);
```
