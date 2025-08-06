package com.osapp.dao;

import com.osapp.model.Endereco;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EnderecoDao {
    private EntityManager em;

    public EnderecoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Endereco> listarTodos() {
        return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }

    public Endereco buscarPorId(Long id) {
        return em.find(Endereco.class, id);
    }

    public void atualizar(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        if (endereco != null) {
            em.getTransaction().begin();
            em.remove(endereco);
            em.getTransaction().commit();
        }
    }
}
