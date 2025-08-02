package com.osapp.controller;

import com.osapp.model.Colaborador;
import com.osapp.repository.ColaboradorDAO;

import java.util.List;

public class ColaboradorController {

    private ColaboradorDAO dao = new ColaboradorDAO();

    public void criar(String nome, String re) {
        Colaborador colaborador = new Colaborador(nome, re);
        dao.salvar(colaborador);
        System.out.println("Colaborador salvo com sucesso.");
    }

    public void listar() {
        List<Colaborador> colaboradores = dao.listarTodos();
        colaboradores.forEach(System.out::println);
    }

    public void finalizar() {
        dao.fechar();
    }
}
