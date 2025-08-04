package com.osapp.view;

import java.util.*;
import com.osapp.util.Tools;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class LayoutDidatico {
    private BorderPane root;

    public LayoutDidatico() {
        root = new BorderPane();

        String[] nomes = { "Salvar", "Editar", "Excluir" };

        List<EventHandler<ActionEvent>> acoes = List.of(
                e -> System.out.println("Salvando..."),
                e -> System.out.println("Editando..."),
                e -> System.out.println("Excluindo..."));

        List<Button> botoes = Tools.criarBotoes(nomes, acoes);

        String estilo = "-fx-background-color: #6495ED;";

        HBox header = Tools.criarHeader("Minha App", estilo, 10, botoes);
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
