package com.osapp.util;

import java.util.List;

import com.osapp.controller.CidadeController;
import com.osapp.controller.ClienteController;
import com.osapp.controller.EstadoController;
import com.osapp.model.Cidade;
import com.osapp.model.Cliente;
import com.osapp.model.Colaborador;
import com.osapp.model.Estado;

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

    public static TableView<Estado> tabelaEstado(EstadoController controller) {
        TableView<Estado> table = Tools.criarTabela(
                new String[] { "Nome", "Sigla" },
                controller.listarEstados());
        return table;
    }
    
    public static TableView<Cliente> tabelaCliente(ClienteController controller) {
        TableView<Cliente> table = Tools.criarTabela(
                new String[] { "Nome", "Sigla" },
                controller.listarClientes());
        return table;
    }

}
