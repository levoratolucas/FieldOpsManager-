package com.osapp.dao;
import java.util.List;

import com.osapp.model.Estado;

import jakarta.persistence.EntityManager;

public class EstadoDao {
    private EntityManager em;

    public EstadoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Estado estado) {
        try {
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Estado> listarTodos() {
        return em.createQuery("SELECT c FROM Estado c", Estado.class).getResultList();
    }

    public Estado buscarPorId(Long id) {
        return em.find(Estado.class, id);
    }

    public void deletar(Long id) {
        Estado c = em.find(Estado.class, id);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
    }
}
