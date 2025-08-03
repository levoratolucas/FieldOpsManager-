package com.osapp.view;

import com.osapp.controller.ColaboradorController;
import com.osapp.model.Colaborador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        Button addBtn = new Button("Adicionar");
        Button editBtn = new Button("Editar");
        Button deleteBtn = new Button("Excluir");

        HBox buttonBox = new HBox(10, addBtn, editBtn, deleteBtn);

        addBtn.setOnAction(e -> {
            if (!nomeInput.getText().isEmpty() && !reInput.getText().isEmpty()) {
                controller.adicionarColaborador(nomeInput.getText(), reInput.getText());
                showAlert("Sucesso", "Colaborador adicionado com sucesso!", Alert.AlertType.INFORMATION);
                atualizarTabela();
            } else {
                showAlert("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            }
        });

        editBtn.setOnAction(e -> {
            Colaborador selecionado = table.getSelectionModel().getSelectedItem();
            if (selecionado != null) {
                selecionado.setName(nomeInput.getText());
                selecionado.setRe(reInput.getText());
                controller.atualizarColaborador(selecionado); // método precisa existir no controller
                showAlert("Sucesso", "Colaborador atualizado com sucesso!", Alert.AlertType.INFORMATION);
                atualizarTabela();
            } else {
                showAlert("Atenção", "Selecione um colaborador para editar", Alert.AlertType.WARNING);
            }
        });

        deleteBtn.setOnAction(e -> {
            Colaborador selecionado = table.getSelectionModel().getSelectedItem();
            if (selecionado != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir?", ButtonType.YES, ButtonType.NO);
                confirm.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.YES) {
                        controller.deletarColaborador(selecionado.getId());
                        showAlert("Sucesso", "Colaborador removido!", Alert.AlertType.INFORMATION);
                        atualizarTabela();
                    }
                });
            } else {
                showAlert("Atenção", "Selecione um colaborador para excluir", Alert.AlertType.WARNING);
            }
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

        table.setOnMouseClicked(e -> {
            Colaborador c = table.getSelectionModel().getSelectedItem();
            if (c != null) {
                nomeInput.setText(c.getName());
                reInput.setText(c.getRe());
            }
        });

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

    private void showAlert(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
