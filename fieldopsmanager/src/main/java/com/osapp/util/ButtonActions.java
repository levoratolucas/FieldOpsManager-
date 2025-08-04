package com.osapp.util;

import com.osapp.controller.ColaboradorController;
import javafx.scene.control.*;
import com.osapp.model.Colaborador;

public class ButtonActions {

    private static void showAlert(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void act(TextField nomeInput, TextField reInput, ColaboradorController controller) {
        if (!nomeInput.getText().isEmpty() && !reInput.getText().isEmpty()) {
            controller.adicionarColaborador(nomeInput.getText(), reInput.getText());
            showAlert("Sucesso", "Colaborador adicionado com sucesso!", Alert.AlertType.INFORMATION);
            // Talvez atualizar tabela aqui também, dependendo do seu design
        } else {
            showAlert("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
        }
    }

    public static void act2(
            TextField nomeInput,
            TextField reInput,
            ColaboradorController controller,
            TableView<Colaborador> table,
            Runnable atualizarTabela) {
        Colaborador selecionado = table.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setName(nomeInput.getText());
            selecionado.setRe(reInput.getText());
            controller.atualizarColaborador(selecionado); // método precisa existir no controller

            // Alerta de sucesso
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("Colaborador atualizado com sucesso!");
            alert.showAndWait();

            // Chama a função passada para atualizar a tabela
            atualizarTabela.run();

            // Limpa os campos, se desejar
            nomeInput.clear();
            reInput.clear();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setContentText("Selecione um colaborador para editar");
            alert.showAndWait();
        }
    }

}
