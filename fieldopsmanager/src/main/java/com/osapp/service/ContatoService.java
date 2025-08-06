package com.osapp.service;

import com.osapp.dao.ContatoDao;
import com.osapp.model.Contato;
import com.osapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoService {

    public void adicionarContato(Contato contato) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ContatoDao dao = new ContatoDao(em);
            dao.salvar(contato);
        } finally {
            em.close();
        }
    }

    public List<Contato> listarContatos() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ContatoDao dao = new ContatoDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarContato(Contato contato) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ContatoDao dao = new ContatoDao(em);
            dao.atualizar(contato);
        } finally {
            em.close();
        }
    }

    public void deletarContato(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ContatoDao dao = new ContatoDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
