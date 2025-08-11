package com.osapp.view;

import com.osapp.controller.ColaboradorController;
import com.osapp.model.Colaborador;
import com.osapp.util.ColaboradorActions;
import com.osapp.util.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class ColaboradorView {
    private VBox layout;
    private TableView<Colaborador> table;
    private TextField nomeInput;
    private TextField reInput;
    private ObservableList<Colaborador> colaboradores;

    private ColaboradorController controller;

    public ColaboradorView() {
        this.controller = new ColaboradorController();

        layout = new VBox(10);
        layout.setPadding(new Insets(15));

        Label label = new Label("Cadastro de Colaboradores");

        nomeInput = new TextField();
        nomeInput.setPromptText("Nome");

        reInput = new TextField();
        reInput.setPromptText("RE");

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

        table.setOnMouseClicked(e -> {
            Colaborador c = table.getSelectionModel().getSelectedItem();
            if (c != null) {
                nomeInput.setText(c.getName());
                reInput.setText(c.getRe());
            }
        });

        ColaboradorActions.nomeInput = nomeInput;
        ColaboradorActions.reInput = reInput;
        ColaboradorActions.table = table;
        ColaboradorActions.controller = controller;
        ColaboradorActions.atualizarTabela = this::atualizarTabela;

        String[] nomes = { "Adicionar", "Editar", "Excluir" };

        List<EventHandler<ActionEvent>> acoes = List.of(
                e -> ColaboradorActions.add(),
                e -> ColaboradorActions.edit(),
                e -> ColaboradorActions.delete());

        List<Button> btn = Tools.criarBotoes(nomes, acoes);

        btn.addAll(Tools.navbar("Colaborador"));

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btn);

        layout.getChildren().addAll(label, nomeInput, reInput, buttonBox, table);
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
