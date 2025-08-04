package com.osapp.util;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Tools {

    public static void criarHeader(BorderPane root) {
        Label header = new Label("HEADER");
        header.setStyle("-fx-background-color: #6495ED; -fx-text-fill: white; -fx-font-size: 18px;");
        header.setPadding(new Insets(10));
        header.setMaxWidth(Double.MAX_VALUE);
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
