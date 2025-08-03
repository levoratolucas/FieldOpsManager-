package com.osapp.controller;

import com.osapp.dao.EstadoDao;
import com.osapp.model.Estado;

import jakarta.persistence.EntityManager;
import java.util.List;


public class EstadoController {
    private EstadoDao dao;

    public EstadoController(EntityManager em) {
        this.dao = new EstadoDao(em);
    }

    public void adicionarEstado(String name, String sigla) {
        Estado Estado = new Estado(name, sigla);
        dao.salvar(Estado);
    }

    public List<Estado> listarEstadoes() {
        return dao.listarTodos();
    }

    public Estado buscarEstadoPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public void deletarEstado(Long id) {
        dao.deletar(id);
    }
}
