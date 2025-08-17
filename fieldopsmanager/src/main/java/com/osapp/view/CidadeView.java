package com.osapp.view;

import java.util.*;

import com.osapp.controller.CidadeController;
import com.osapp.model.Cidade;
import com.osapp.util.Table;
import com.osapp.util.Tools;
import com.osapp.util.ViewManager;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class CidadeView {
    private BorderPane root;
    private CidadeController controller;

    public CidadeView() {
        
        root = new BorderPane();
        controller = new CidadeController();

        

        List<Button> botoes = Tools.navbar("Cidade");

        String estilo = "-fx-background-color: #6495ED;";

        HBox header = Tools.criarHeader("CidadeView", estilo, 10, botoes);
        VBox nav = Tools.nav();
        VBox workspace = Tools.workspace();
        HBox mainContent = Tools.criarMain(nav, workspace);
        Label footer = Tools.criarFooter();

        TableView<Cidade> table = Table.tabelaCidade(controller);
        workspace.getChildren().add(table);

        root.setTop(header);
        root.setCenter(mainContent);
        root.setBottom(footer);
    }

    public BorderPane getView() {
        return root;
    }
}
