package com.osapp.util;

import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

    public static List<Button> Buttons(String... names) {
        List<Button> botoes = new ArrayList<>();

        for (String name : names) {
            botoes.add(new Button(name));
        }

        return botoes;
    }

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
}
