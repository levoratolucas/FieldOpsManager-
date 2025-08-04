package com.osapp.util;

import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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

    public static void criarHeader(BorderPane root, String title, String style, int padding, List<Button> botoes) {
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
        root.setTop(header);
    }

    public static void criarMain(BorderPane root) {
        VBox nav = new VBox();
        nav.setStyle("-fx-background-color: #FFA07A;");
        nav.setPadding(new Insets(10));
        nav.getChildren().add(new Label("Navegação"));

        VBox workspace = new VBox();
        workspace.setStyle("-fx-background-color: #98FB98;");
        workspace.setPadding(new Insets(10));
        workspace.getChildren().add(new Label("Workspace"));

        HBox mainContent = new HBox(10);
        mainContent.getChildren().addAll(nav, workspace);

        mainContent.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();
            nav.setPrefWidth(width * 0.3);
            workspace.setPrefWidth(width * 0.7);
        });

        root.setCenter(mainContent);
    }

    public static void criarFooter(BorderPane root) {
        Label footer = new Label("FOOTER");
        footer.setStyle("-fx-background-color: #555555; -fx-text-fill: white; -fx-font-size: 14px;");
        footer.setPadding(new Insets(10));
        footer.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(footer, new Insets(5, 0, 0, 0));
        root.setBottom(footer);
    }
}
