package com.osapp.view;

import java.util.List;

import com.osapp.controller.EstadoController;
import com.osapp.util.Table;
import com.osapp.util.Tools;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.TableView;

public class EstadoView {
    private BorderPane root;
    private EstadoController controller;

    public EstadoView() {
        root = new BorderPane();
        controller = new EstadoController(); // inicializa o controller

        List<Button> botoes = Tools.navbar("Estado");

        String estilo = "-fx-background-color: #6495ED;";
        HBox header = Tools.criarHeader("EstadoView", estilo, 10, botoes);
        VBox nav = Tools.nav();
        VBox workspace = Tools.workspace();
        HBox mainContent = Tools.criarMain(nav, workspace);
        Label footer = Tools.criarFooter();

        TableView<?> table = Table.tabelaEstado(controller);

        workspace.getChildren().add(table);

        root.setTop(header);
        root.setCenter(mainContent);
        root.setBottom(footer);
    }

    public BorderPane getView() {
        return root;
    }
}
