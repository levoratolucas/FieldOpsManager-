package com.osapp.controller;

import com.osapp.dao.ColaboradorDao;
import com.osapp.model.Colaborador;

import jakarta.persistence.EntityManager;
import java.util.List;


public class ColaboradorController {
    private ColaboradorDao dao;

    public ColaboradorController(EntityManager em) {
        this.dao = new ColaboradorDao(em);
    }

    public void adicionarColaborador(String nome, String cargo) {
        Colaborador colaborador = new Colaborador(nome, cargo);
        dao.salvar(colaborador);
    }

    public List<Colaborador> listarColaboradores() {
        return dao.listarTodos();
    }

    public Colaborador buscarColaboradorPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public void deletarColaborador(Long id) {
        dao.deletar(id);
    }
}
