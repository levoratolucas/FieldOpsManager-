package com.osapp.repository;

import com.osapp.model.Colaborador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ColaboradorDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("osappPU");

    public void salvar(Colaborador colaborador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(colaborador);
        em.getTransaction().commit();
        em.close();
    }

    public List<Colaborador> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Colaborador> lista = em.createQuery("FROM Colaborador", Colaborador.class).getResultList();
        em.close();
        return lista;
    }

    public void fechar() {
        emf.close();
    }
}
