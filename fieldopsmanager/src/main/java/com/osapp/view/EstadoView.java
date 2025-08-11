package com.osapp.view;

import java.util.*;
import com.osapp.util.Tools;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class EstadoView {
    private BorderPane root;

    public EstadoView() {
        root = new BorderPane();

        List<Button> botoes = Tools.navbar("Estado");

        String estilo = "-fx-background-color: #6495ED;";

        HBox header = Tools.criarHeader("EstadoView", estilo, 10, botoes);
        VBox nav = Tools.nav();
        VBox workspace = Tools.workspace();
        HBox mainContent = Tools.criarMain(nav, workspace);
        Label footer = Tools.criarFooter();

        root.setTop(header);
        root.setCenter(mainContent);
        root.setBottom(footer);
    }

    public BorderPane getView() {
        return root;
    }
}
