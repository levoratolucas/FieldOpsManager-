package com.osapp.util;

import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class Tools {

    // public static void criarHeader(BorderPane root, String nameLabel, String
    // style, int padding) {
    // Label header = new Label(nameLabel);
    // header.setStyle(style);
    // header.setPadding(new Insets(padding));
    // header.setMaxWidth(Double.MAX_VALUE);
    // BorderPane.setMargin(header, new Insets(0, 0, 5, 0));
    // root.setTop(header);
    // }

    public static Object controler;

    public static Button criarBotao(String texto, EventHandler<ActionEvent> acao) {
        Button botao = new Button(texto);
        botao.setOnAction(acao);
        return botao;
    }

    public static List<Button> criarBotoes(String[] nomes, List<EventHandler<ActionEvent>> acoes) {
        List<Button> botoes = new ArrayList<>();

        if (nomes.length != acoes.size()) {
            throw new IllegalArgumentException("O número de nomes e ações deve ser igual.");
        }

        for (int i = 0; i < nomes.length; i++) {
            Button botao = new Button(nomes[i]);
            botao.setOnAction(acoes.get(i));
            botoes.add(botao);
        }

        return botoes;
    }

    // -------------------------------------------------------------- teste função
    // grid
    public static GridPane criarGridGenerico(List<Node> nodes, int colunas) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setGridLinesVisible(true);

        for (int i = 0; i < nodes.size(); i++) {
            int col = i % colunas;
            int row = i / colunas;
            grid.add(nodes.get(i), col, row);
        }

        // Faz as colunas expandirem igualmente
        for (int i = 0; i < colunas; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        return grid;
    }

    public static GridPane criarGridBotoes(List<Button> botoes) {
        GridPane grid = new GridPane();
        grid.setHgap(10); // espaço horizontal entre os botões
        grid.setVgap(10); // espaço vertical entre os botões
        grid.setPadding(new Insets(10));
        grid.setGridLinesVisible(false);

        int colunas = 3; // sempre 3 colunas
        for (int i = 0; i < botoes.size(); i++) {
            int col = i % colunas; // posição da coluna (0,1,2)
            int row = i / colunas; // posição da linha
            grid.add(botoes.get(i), col, row);
        }

        // Faz os botões expandirem para preencher as células
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2, col3);

        return grid;
    }

    // -------------------------------------------------------------- teste função
    // grid

    public static HBox criarHeader(String title, String style, int padding, List<Button> botoes) {
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); // empurra os botões para a direita

        HBox header = new HBox(10); // espaçamento entre elementos
        header.setStyle(style);
        header.setPadding(new Insets(padding));
        header.setMaxWidth(Double.MAX_VALUE);

        // Adiciona título, espaçador e os botões recebidos
        header.getChildren().add(titleLabel);
        header.getChildren().add(spacer);
        header.getChildren().addAll(botoes);

        BorderPane.setMargin(header, new Insets(0, 0, 5, 0));

        return header;
    }

    public static VBox nav() {
        VBox nav = new VBox();
        nav.setStyle("-fx-background-color: #FFA07A;");
        nav.setPadding(new Insets(10));
        nav.getChildren().add(new Label("Navegação"));
        return nav;
    }

    public static VBox workspace() {
        VBox workspace = new VBox();
        workspace.setStyle("-fx-background-color: #98FB98;");
        workspace.setPadding(new Insets(10));
        workspace.getChildren().add(new Label("Workspace"));
        return workspace;
    }

    public static HBox criarMain(VBox nav, VBox workspace) {

        HBox mainContent = new HBox(10);
        mainContent.getChildren().addAll(nav, workspace);

        mainContent.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();
            nav.setPrefWidth(width * 0.3);
            workspace.setPrefWidth(width * 0.7);
        });

        return mainContent;
    }

    public static Label criarFooter() {
        Label footer = new Label("FOOTER");
        footer.setStyle("-fx-background-color: #555555; -fx-text-fill: white; -fx-font-size: 14px;");
        footer.setPadding(new Insets(10));
        footer.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(footer, new Insets(5, 0, 0, 0));
        return footer;
    }

    public static List<Button> navbar(String... excluir) {
        // Mapeamento nome -> ação
        Map<String, Runnable> botoesAcoes = Map.of(
                "Cidade", () -> ViewManager.mostrarCidadeView(),
                "Cliente", () -> ViewManager.mostrarClienteView(),
                "Colaborador", () -> ViewManager.mostrarColaboradorView(),
                "Estado", () -> ViewManager.mostrarEstadoView(),
                "OS", () -> ViewManager.mostrarOsView());

        // Lista com nomes que devem ser excluídos
        List<String> excluirList = Arrays.asList(excluir);

        // Filtra e cria botões
        List<String> nomesFiltrados = botoesAcoes.keySet().stream()
                .filter(nome -> !excluirList.contains(nome))
                .toList();

        List<EventHandler<ActionEvent>> acoes = nomesFiltrados.stream()
                .map(nome -> (EventHandler<ActionEvent>) e -> botoesAcoes.get(nome).run())
                .toList();

        return Tools.criarBotoes(nomesFiltrados.toArray(new String[0]), acoes);
    }

    public static <Listar> TableView<Listar> criarTabela(String[] colunas, List<Listar> objetos) {
        TableView<Listar> table = new TableView<>();
        ObservableList<Listar> data = FXCollections.observableArrayList(objetos);
        table.setItems(data);

        for (int i = 0; i < colunas.length; i++) {
            final int index = i;
            TableColumn<Listar, String> col = new TableColumn<>(colunas[i]);
            col.setCellValueFactory(c -> {
                String[] partes = c.getValue().toString().split("\\|");
                if (index < partes.length) {
                    return new javafx.beans.property.SimpleStringProperty(partes[index]);
                } else {
                    return new javafx.beans.property.SimpleStringProperty("");
                }
            });
            table.getColumns().add(col);
        }

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }
}
