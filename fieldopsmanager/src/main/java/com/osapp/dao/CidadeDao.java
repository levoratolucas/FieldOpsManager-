package com.osapp.dao;

import com.osapp.model.Cidade;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CidadeDao {
    private EntityManager em;

    public CidadeDao(EntityManager em) {
        this.em = em;
    }

    public Cidade salvar(Cidade cidade) {
        try {
            em.getTransaction().begin();
            em.persist(cidade);
            em.getTransaction().commit();
           
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        return cidade;
    }

    public List<Cidade> listarTodos() {
        return em.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
    }

    public Cidade buscarPorId(Long id) {
        return em.find(Cidade.class, id);
    }

    public void atualizar(Cidade cidade) {
        try {
            em.getTransaction().begin();
            em.merge(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        Cidade cidade = em.find(Cidade.class, id);
        if (cidade != null) {
            em.getTransaction().begin();
            em.remove(cidade);
            em.getTransaction().commit();
        }
    }
}
