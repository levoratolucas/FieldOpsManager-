package com.osapp.util;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.osapp.view.*;

public class ViewManager {
    private static Stage stage;

    public static void setStage(Stage mainStage) {
        stage = mainStage;
    }

    public static void mostrarCidadeView() {
        CidadeView view = new CidadeView();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }

    public static void mostrarClienteView() {
        ClienteView view = new ClienteView();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }

    public static void mostrarColaboradorView() {
        ColaboradorView view = new ColaboradorView();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }

    public static void mostrarEstadoView() {
        EstadoView view = new EstadoView();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }

    public static void mostrarLayoutDidaticoView() {
        LayoutDidatico view = new LayoutDidatico();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }

    public static void mostrarOsView() {
        OsView view = new OsView();
        stage.setScene(new Scene(view.getView(), 800, 600));
    }
}
