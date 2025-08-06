package com.osapp.dao;

import java.util.List;

import com.osapp.model.Colaborador;

import jakarta.persistence.EntityManager;

public class ColaboradorDao {
    private EntityManager em;

    public ColaboradorDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Colaborador colaborador) {
        try {
            em.getTransaction().begin();
            em.persist(colaborador);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Colaborador> listarTodos() {
        return em.createQuery("SELECT c FROM Colaborador c", Colaborador.class).getResultList();
    }

    public Colaborador buscarPorId(Long id) {
        return em.find(Colaborador.class, id);
    }

    public void deletar(Long id) {
        Colaborador c = em.find(Colaborador.class, id);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
    }

    public void atualizar(Colaborador colaborador) {
        try {
            em.getTransaction().begin();
            em.merge(colaborador);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
