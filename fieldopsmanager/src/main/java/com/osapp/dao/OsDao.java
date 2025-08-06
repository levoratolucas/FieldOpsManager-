package com.osapp.dao;

import com.osapp.model.OS;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OsDao {
    private EntityManager em;

    public OsDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(OS os) {
        try {
            em.getTransaction().begin();
            em.persist(os);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<OS> listarTodos() {
        return em.createQuery("SELECT o FROM OS o", OS.class).getResultList();
    }

    public OS buscarPorId(Long id) {
        return em.find(OS.class, id);
    }

    public void atualizar(OS os) {
        try {
            em.getTransaction().begin();
            em.merge(os);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        OS os = em.find(OS.class, id);
        if (os != null) {
            em.getTransaction().begin();
            em.remove(os);
            em.getTransaction().commit();
        }
    }
}
