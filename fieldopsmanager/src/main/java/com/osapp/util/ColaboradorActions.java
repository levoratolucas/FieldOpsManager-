package com.osapp.util;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import com.osapp.model.Colaborador;
import com.osapp.controller.ColaboradorController;
import com.osapp.view.ColaboradorView;

public class ColaboradorActions {
    public static TextField nomeInput;
    public static TextField reInput;
    public static TableView<Colaborador> table;
    public static ColaboradorController controller;
    public static Runnable atualizarTabela;

    public static void showAlert(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void add() {
        if (!nomeInput.getText().isEmpty() && !reInput.getText().isEmpty()) {
            controller.adicionarColaborador(nomeInput.getText(), reInput.getText());
            showAlert("Sucesso", "Colaborador adicionado com sucesso!", Alert.AlertType.INFORMATION);
            atualizarTabela.run();
        } else {
            showAlert("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
        }
    }

    public static void edit() {
        Colaborador selecionado = table.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setName(nomeInput.getText());
            selecionado.setRe(reInput.getText());
            controller.atualizarColaborador(selecionado);
            showAlert("Sucesso", "Colaborador atualizado com sucesso!", Alert.AlertType.INFORMATION);
            atualizarTabela.run();
        } else {
            showAlert("Atenção", "Selecione um colaborador para editar", Alert.AlertType.WARNING);
        }
    }

    public static void delete() {
        Colaborador selecionado = table.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir?",
                    ButtonType.YES, ButtonType.NO);
            confirm.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    controller.deletarColaborador(selecionado.getId());
                    showAlert("Sucesso", "Colaborador removido!", Alert.AlertType.INFORMATION);
                    atualizarTabela.run();
                }
            });
        } else {
            showAlert("Atenção", "Selecione um colaborador para excluir", Alert.AlertType.WARNING);
        }
    }
}
