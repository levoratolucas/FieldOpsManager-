package com.osapp.service;

import com.osapp.dao.EquipamentoDao;
import com.osapp.model.Equipamento;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EquipamentoService {

    public void adicionarEquipamento(String name, String tipo) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EquipamentoDao dao = new EquipamentoDao(em);
            dao.salvar(new Equipamento(name, tipo));
        } finally {
            em.close();
        }
    }

    public List<Equipamento> listarEquipamentos() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EquipamentoDao dao = new EquipamentoDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarEquipamento(Equipamento equipamento) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EquipamentoDao dao = new EquipamentoDao(em);
            dao.atualizar(equipamento);
        } finally {
            em.close();
        }
    }

    public void deletarEquipamento(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EquipamentoDao dao = new EquipamentoDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
