package com.osapp.controller;

import java.util.List;

import com.osapp.dao.ColaboradorDao;
import com.osapp.model.Colaborador;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class ColaboradorController {

    public void adicionarColaborador(String nome, String cargo) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ColaboradorDao dao = new ColaboradorDao(em);
            dao.salvar(new Colaborador(nome, cargo));
        } finally {
            em.close();
        }
    }

    public List<Colaborador> listarColaboradores() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ColaboradorDao dao = new ColaboradorDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }
}
