// package com.osapp.view;

// import javafx.scene.layout.*;
// import javafx.geometry.Pos;
// import javafx.scene.control.*;

// public class OsView {
//     private BorderPane root;

//     public OsView() {
//         // root = new BorderPane();

//         // List<Button> botoes = Tools.navbar("OS");

//         // String estilo = "-fx-background-color: #6495ED;";

//         // HBox header = Tools.criarHeader("OsView", estilo, 10, botoes);
//         // VBox nav = Tools.nav();
//         // VBox workspace = Tools.workspace();
//         // HBox mainContent = Tools.criarMain(nav, workspace);
//         // Label footer = Tools.criarFooter();

//         // // ----------------------------------------------- 
//         // String estilo2 = "-fx-background-color: #ffff00ff;";

//         // VBox top = new VBox();

//         // top.setStyle("-fx-background-color: #ed6464ff;");

//         // HBox leftBox = new HBox();
//         // leftBox.setStyle("-fx-background-color: #6495ED;");
//         // Label label = new Label("esquerda");
//         // leftBox.setPrefWidth(300);
//         // leftBox.getChildren().add(label);

//         // Label label2 = new Label("direita");
//         // HBox rigthHBox = new HBox();
//         // rigthHBox.setStyle(estilo2);
//         // rigthHBox.setPrefWidth(100);
//         // rigthHBox.getChildren().add(label2);

//         // HBox leftBox2 = new HBox();
//         // leftBox2.setStyle("-fx-background-color: #6495ED;");
//         // Label label3 = new Label("esquerda");
//         // leftBox2.setPrefWidth(300);
//         // leftBox2.getChildren().add(label3);

//         // Label label4 = new Label("direita");
//         // HBox rigthHBox2 = new HBox();
//         // rigthHBox2.setStyle(estilo2);
//         // rigthHBox2.setPrefWidth(100);
//         // rigthHBox2.getChildren().add(label4);

//         // HBox top1 = new HBox();
//         // top1.getChildren().addAll(leftBox,rigthHBox);
//         // HBox top2 = new HBox();
//         // top2.getChildren().addAll(rigthHBox2,leftBox2);

//         // top.getChildren().addAll(top1,top2);
//         // top.setPrefHeight(60);

//         // root.setTop(top);

//         // // ----------------------------------------------- 
//         // root.setCenter(mainContent);
//         // root.setBottom(footer);

//         root = new BorderPane();

//         GridPane grid = new GridPane();
//         grid.setGridLinesVisible(true); // mostra as linhas da grade
//         grid.setPrefSize(500, 500); // tamanho da tela

//         // 10 colunas e 10 linhas
//         for (int i = 0; i < 10; i++) {
//             ColumnConstraints col = new ColumnConstraints();
//             col.setPercentWidth(10); // cada coluna ocupa 10%
//             grid.getColumnConstraints().add(col);

//             RowConstraints row = new RowConstraints();
//             row.setPercentHeight(10); // cada linha ocupa 10%
//             grid.getRowConstraints().add(row);
//         }

//         // Preenchendo cada célula com Label "i,j"
//         for (int row = 0; row < 10; row++) {
//             for (int col = 0; col < 10; col++) {
//                 Label label = new Label(row + "," + col);
//                 label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//                 label.setAlignment(Pos.CENTER);
//                 grid.add(label, col, row);
//             }
//         }

//         root.setCenter(grid);
//     }

//     public BorderPane getView() {
//         return root;
//     }
// }

// ---------------------------------------- treino GRID --------------------------------------  

package com.osapp.view;

import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

import com.osapp.util.Tools;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;

public class OsView {
    private BorderPane root;

    public OsView() {
        // root = new BorderPane();

        // List<Button> botoes = Tools.navbar("OS");

        // String estilo = "-fx-background-color: #6495ED;";

        // HBox header = Tools.criarHeader("OsView", estilo, 10, botoes);
        // VBox nav = Tools.nav();
        // VBox workspace = Tools.workspace();
        // HBox mainContent = Tools.criarMain(nav, workspace);
        // Label footer = Tools.criarFooter();

        // // -----------------------------------------------
        // String estilo2 = "-fx-background-color: #ffff00ff;";

        // VBox top = new VBox();

        // top.setStyle("-fx-background-color: #ed6464ff;");

        // HBox leftBox = new HBox();
        // leftBox.setStyle("-fx-background-color: #6495ED;");
        // Label label = new Label("esquerda");
        // leftBox.setPrefWidth(300);
        // leftBox.getChildren().add(label);

        // Label label2 = new Label("direita");
        // HBox rigthHBox = new HBox();
        // rigthHBox.setStyle(estilo2);
        // rigthHBox.setPrefWidth(100);
        // rigthHBox.getChildren().add(label2);

        // HBox leftBox2 = new HBox();
        // leftBox2.setStyle("-fx-background-color: #6495ED;");
        // Label label3 = new Label("esquerda");
        // leftBox2.setPrefWidth(300);
        // leftBox2.getChildren().add(label3);

        // Label label4 = new Label("direita");
        // HBox rigthHBox2 = new HBox();
        // rigthHBox2.setStyle(estilo2);
        // rigthHBox2.setPrefWidth(100);
        // rigthHBox2.getChildren().add(label4);

        // HBox top1 = new HBox();
        // top1.getChildren().addAll(leftBox,rigthHBox);
        // HBox top2 = new HBox();
        // top2.getChildren().addAll(rigthHBox2,leftBox2);

        // top.getChildren().addAll(top1,top2);
        // top.setPrefHeight(60);

        // root.setTop(top);

        // // -----------------------------------------------
        // root.setCenter(mainContent);
        // root.setBottom(footer);

        root = new BorderPane();

        HBox top = new HBox();
        HBox center = new HBox();

        GridPane grid = Tools.criarGridBotoes(Tools.navbar("OS"));
        // }

        top.getChildren().add(grid);

        List<Node> elementos = new ArrayList<>();
        elementos.add(new Button("Botão 1"));
        elementos.add(new Label("Sou uma Label"));
        elementos.add(new HBox(new Button("Dentro do HBox")));
        elementos.add(new TextField("Digite aqui"));
        elementos.add(new CheckBox("Concordo"));

        GridPane grid2 = Tools.criarGridGenerico(elementos, 3); // sempre 3 colunas

        // // Preenchendo cada célula com Label "i,j"
        // for (int row = 0; row < 10; row++) {
        // for (int col = 0; col < 10; col++) {
        // Label label = new Label(row + "," + col);
        // label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // label.setAlignment(Pos.CENTER);
        // grid.add(label, col, row);
        // }
        // }

        root.setTop(top);
        root.setCenter(grid2);
    }

    public BorderPane getView() {
        return root;
    }
}
