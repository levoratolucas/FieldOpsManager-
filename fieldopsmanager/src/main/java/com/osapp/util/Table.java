package com.osapp.util;

import java.util.List;

import com.osapp.controller.CidadeController;
import com.osapp.model.Cidade;
import com.osapp.model.Colaborador;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;;

public class Table {

    public static TableView<Colaborador> tableColaborador(List<Colaborador> colaboradores) {

        String[] nomesColunas = { "ID", "Nome", "RE" };
        TableView<Colaborador> table = Tools.criarTabela(nomesColunas, colaboradores);
        table.setItems((ObservableList<Colaborador>) colaboradores);
        return table;
    }

    public static TableView<Cidade> tabelaCidade(CidadeController controller) {
        TableView<Cidade> table = Tools.criarTabela(
                new String[] { "Cidade", "Estado", "Sigla" },
                controller.listarCidades());
        return table;
    }

}
