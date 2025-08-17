package com.osapp.view;

import java.util.*;
import com.osapp.util.Tools;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class LayoutDidatico {
    private BorderPane root;

    public LayoutDidatico() {
        root = new BorderPane();
        String estilo = "-fx-background-color: #000000ff;";

        HBox top = new HBox();

        top.setStyle("-fx-background-color: #ed6464ff;");

        HBox leftBox = new HBox();
        leftBox.setStyle("-fx-background-color: #6495ED;");
        HBox rigthHBox = new HBox();
        rigthHBox.setStyle(estilo);

        top.getChildren().addAll(leftBox,rigthHBox);

        root.setTop(top);
        // root.setCenter();
        // root.setBottom();
    }

    public BorderPane getView() {
        return root;
    }
}
