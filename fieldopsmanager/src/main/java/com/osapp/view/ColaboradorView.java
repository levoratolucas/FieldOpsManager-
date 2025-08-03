package com.osapp.view;

import com.osapp.controller.ColaboradorController;
import com.osapp.model.Colaborador;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ColaboradorView {
    private VBox layout;
    private TableView<Colaborador> table;
    private TextField nomeInput;
    private TextField reInput;
    private ObservableList<Colaborador> colaboradores;

    private ColaboradorController controller;

    public ColaboradorView() {
        EntityManager em = JpaUtil.getEntityManager();
        this.controller = new ColaboradorController();

        layout = new VBox(10);
        layout.setPadding(new Insets(15));

        Label label = new Label("Cadastro de Colaboradores");

        nomeInput = new TextField();
        nomeInput.setPromptText("Nome");

        reInput = new TextField();
        reInput.setPromptText("RE");

        Button addBtn = new Button("Adicionar");
        addBtn.setOnAction(e -> {
            controller.adicionarColaborador(nomeInput.getText(), reInput.getText());
            atualizarTabela();
        });

        colaboradores = FXCollections.observableArrayList(controller.listarColaboradores());

        table = new TableView<>(colaboradores);
        TableColumn<Colaborador, Long> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getId()).asObject());

        TableColumn<Colaborador, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        TableColumn<Colaborador, String> reCol = new TableColumn<>("RE");
        reCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getRe()));

        table.getColumns().addAll(idCol, nomeCol, reCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        layout.getChildren().addAll(label, nomeInput, reInput, addBtn, table);
    }

    public VBox getView() {
        return layout;
    }

    private void atualizarTabela() {
        colaboradores.setAll(controller.listarColaboradores());
        nomeInput.clear();
        reInput.clear();
    }
}
