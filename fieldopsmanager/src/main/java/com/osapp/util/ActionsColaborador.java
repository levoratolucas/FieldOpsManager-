package com.osapp.util;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import com.osapp.controller.ColaboradorController;
import com.osapp.view.ColaboradorView;

public class ActionsColaborador {
    public static TextField nomeInput;
    public static TextField reInput;
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
    
}
