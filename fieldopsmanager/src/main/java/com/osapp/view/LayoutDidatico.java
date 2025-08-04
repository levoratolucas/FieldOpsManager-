package com.osapp.view;

import com.osapp.util.Tools;
import javafx.scene.layout.BorderPane;

public class LayoutDidatico {
    private BorderPane root;

    public LayoutDidatico() {
        root = new BorderPane();
        Tools.criarHeader(root);
        Tools.criarMain(root);
        Tools.criarFooter(root);
    }

    public BorderPane getView() {
        return root;
    }
}
