package com.osapp.dao;

import com.osapp.model.Estado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EstadoDao {

    private EntityManager em;

    public EstadoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Estado estado) {
        em.persist(estado);
    }

    public List<Estado> listarTodos() {
        TypedQuery<Estado> query = em.createQuery("SELECT c FROM Estado c", Estado.class);
        return query.getResultList();
    }

    public Estado buscarPorId(Long id) {
        return em.find(Estado.class, id);
    }

    public void deletar(Long id) {
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            em.remove(estado);
        }
    }
}
