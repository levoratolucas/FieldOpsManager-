package com.osapp.service;

import com.osapp.dao.EstadoDao;
import com.osapp.model.Estado;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EstadoService {

    public void adicionarEstado(String nome, String sigla) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EstadoDao dao = new EstadoDao(em);
            dao.salvar(new Estado(nome, sigla));
        } finally {
            em.close();
        }
    }

    public List<Estado> listarEstados() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EstadoDao dao = new EstadoDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarEstado(Estado estado) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EstadoDao dao = new EstadoDao(em);
            dao.atualizar(estado);
        } finally {
            em.close();
        }
    }

    public void deletarEstado(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EstadoDao dao = new EstadoDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
