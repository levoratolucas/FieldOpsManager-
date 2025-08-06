package com.osapp.dao;

import com.osapp.model.Scripts;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ScriptsDao {
    private EntityManager em;

    public ScriptsDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Scripts scripts) {
        try {
            em.getTransaction().begin();
            em.persist(scripts);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Scripts> listarTodos() {
        return em.createQuery("SELECT s FROM Scripts s", Scripts.class).getResultList();
    }

    public Scripts buscarPorId(Long id) {
        return em.find(Scripts.class, id);
    }

    public void atualizar(Scripts scripts) {
        try {
            em.getTransaction().begin();
            em.merge(scripts);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        Scripts scripts = em.find(Scripts.class, id);
        if (scripts != null) {
            em.getTransaction().begin();
            em.remove(scripts);
            em.getTransaction().commit();
        }
    }
}
