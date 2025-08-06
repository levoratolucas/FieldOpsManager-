package com.osapp.dao;

import com.osapp.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {
    private EntityManager em;

    public ContatoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Contato contato) {
        try {
            em.getTransaction().begin();
            em.persist(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Contato> listarTodos() {
        return em.createQuery("SELECT c FROM Contato c", Contato.class).getResultList();
    }

    public Contato buscarPorId(Long id) {
        return em.find(Contato.class, id);
    }

    public void atualizar(Contato contato) {
        try {
            em.getTransaction().begin();
            em.merge(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        Contato contato = em.find(Contato.class, id);
        if (contato != null) {
            em.getTransaction().begin();
            em.remove(contato);
            em.getTransaction().commit();
        }
    }
}
