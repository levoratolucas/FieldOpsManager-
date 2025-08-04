package com.osapp.view;

import java.util.*;
import com.osapp.util.Tools;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;

public class LayoutDidatico {
    private BorderPane root;

    public LayoutDidatico() {
        root = new BorderPane();

        List<Button> botoes = Tools.Buttons("btn1", "btn2", "btn3", "btn4","btn1", "btn2", "btn3", "btn4");

        String estilo = "-fx-background-color: #6495ED;";

        Tools.criarHeader(root, "Minha App", estilo, 10, botoes);
        Tools.criarMain(root);
        Tools.criarFooter(root);
    }

    public BorderPane getView() {
        return root;
    }
}
