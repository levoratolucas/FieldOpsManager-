package com.osapp.view;

import com.osapp.controller.CidadeController;
import com.osapp.controller.ColaboradorController;
import com.osapp.model.Cidade;
import com.osapp.model.Colaborador;
import com.osapp.util.ColaboradorActions;
import com.osapp.util.Table;
import com.osapp.util.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class ColaboradorView {
    private TextField nomeInput;
    private TextField reInput;
    private ObservableList<Colaborador> colaboradores;

    private ColaboradorController controller;
    private BorderPane root;

    public ColaboradorView() {
        root = new BorderPane();
        this.controller = new ColaboradorController();
        CidadeController cidadeController = new CidadeController();

        Label label = new Label("Cadastro de Colaboradores");

        nomeInput = new TextField();
        nomeInput.setPromptText("Nome");

        reInput = new TextField();
        reInput.setPromptText("RE");

        colaboradores = FXCollections.observableArrayList(controller.listarColaboradores());

        TableView<Colaborador> table = Table.tableColaborador(colaboradores);

        table.setItems(colaboradores);

        table.setOnMouseClicked(e -> ColaboradorActions.selectByTable(table, nomeInput, reInput));

        ColaboradorActions.nomeInput = nomeInput;
        ColaboradorActions.reInput = reInput;
        ColaboradorActions.table = table;
        ColaboradorActions.controller = controller;
        ColaboradorActions.atualizarTabela = this::atualizarTabela;

        String[] nomes = { "Adicionar", "Editar", "Excluir", "Cliente table","Colaborador" };
        VBox workspace = Tools.workspace();

        List<EventHandler<ActionEvent>> acoes = List.of(
                e -> ColaboradorActions.add(),
                e -> ColaboradorActions.edit(),
                e -> ColaboradorActions.delete(),
                e -> {
                    TableView<Cidade> tabelaCidade = Table.tabelaCidade(cidadeController);
                    workspace.getChildren().setAll(tabelaCidade);
                },
                e -> {
                    TableView<Colaborador> tabelaColaborador = Table.tableColaborador(colaboradores);
                    workspace.getChildren().setAll(tabelaColaborador);
                });

        List<Button> btn2 = Tools.criarBotoes(nomes, acoes);

        List<Button> btn = Tools.navbar("Colaborador");

        String estilo = "-fx-background-color: #6495ED;";
        HBox header = Tools.criarHeader("EstadoView", estilo, 10, btn);
        VBox nav = Tools.nav();
        nav.getChildren().addAll(label, nomeInput, reInput);
        nav.getChildren().addAll(btn2);
        workspace.getChildren().addAll(table);
        HBox mainContent = Tools.criarMain(nav, workspace);
        Label footer = Tools.criarFooter();

        root.setTop(header);
        root.setCenter(mainContent);
        root.setBottom(footer);

    }

    public BorderPane getView() {
        return root;
    }

    private void atualizarTabela() {
        colaboradores.setAll(controller.listarColaboradores());
        nomeInput.clear();
        reInput.clear();
    }

}
