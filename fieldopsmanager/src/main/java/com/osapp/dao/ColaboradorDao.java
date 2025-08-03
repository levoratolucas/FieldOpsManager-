package com.osapp.dao;

import com.osapp.model.Colaborador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ColaboradorDao {

    private EntityManager em;

    public ColaboradorDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Colaborador colaborador) {
        em.persist(colaborador);
    }

    public List<Colaborador> listarTodos() {
        TypedQuery<Colaborador> query = em.createQuery("SELECT c FROM Colaborador c", Colaborador.class);
        return query.getResultList();
    }

    public Colaborador buscarPorId(Long id) {
        return em.find(Colaborador.class, id);
    }

    public void deletar(Long id) {
        Colaborador colaborador = em.find(Colaborador.class, id);
        if (colaborador != null) {
            em.remove(colaborador);
        }
    }
}
