package com.osapp;

import com.osapp.view.ColaboradorView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        ColaboradorView colaboradorView = new ColaboradorView();
        Scene scene = new Scene(colaboradorView.getView(), 600, 400);

        primaryStage.setTitle("Gestão de Colaboradores");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
