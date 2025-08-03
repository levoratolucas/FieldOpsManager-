package com.osapp.service;

import com.osapp.dao.ColaboradorDao;
import com.osapp.model.Colaborador;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ColaboradorService {

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

    public void atualizarColaborador(Colaborador colaborador) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(colaborador);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deletarColaborador(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ColaboradorDao dao = new ColaboradorDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
