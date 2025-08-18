package com.osapp.view;

import java.util.*;

import com.osapp.controller.ClienteController;
import com.osapp.util.Table;
import com.osapp.util.Tools;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClienteView {
    private BorderPane root;
    private ClienteController controller;
    

    public ClienteView() {
        root = new BorderPane();

        List<Button> botoes = Tools.navbar("Cliente");

        String estilo = "-fx-background-color: #6495ED;";

        HBox header = Tools.criarHeader("ClienteView", estilo, 10, botoes);
        VBox nav = Tools.nav();
        VBox workspace = Tools.workspace();
        HBox mainContent = Tools.criarMain(nav, workspace);
        Label footer = Tools.criarFooter();

        TableView<?> table = Table.tabelaCliente(controller);
        workspace.getChildren().add(table);
        

        root.setTop(header);
        root.setCenter(mainContent);
        root.setBottom(footer);
    }

    public BorderPane getView() {
        return root;
    }
}
