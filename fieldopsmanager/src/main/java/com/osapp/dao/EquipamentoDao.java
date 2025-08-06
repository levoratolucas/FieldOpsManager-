package com.osapp.dao;

import com.osapp.model.Equipamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EquipamentoDao {
    private EntityManager em;

    public EquipamentoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Equipamento equipamento) {
        try {
            em.getTransaction().begin();
            em.persist(equipamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Equipamento> listarTodos() {
        return em.createQuery("SELECT e FROM Equipamento e", Equipamento.class).getResultList();
    }

    public Equipamento buscarPorId(Long id) {
        return em.find(Equipamento.class, id);
    }

    public void atualizar(Equipamento equipamento) {
        try {
            em.getTransaction().begin();
            em.merge(equipamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        Equipamento equipamento = em.find(Equipamento.class, id);
        if (equipamento != null) {
            em.getTransaction().begin();
            em.remove(equipamento);
            em.getTransaction().commit();
        }
    }
}
