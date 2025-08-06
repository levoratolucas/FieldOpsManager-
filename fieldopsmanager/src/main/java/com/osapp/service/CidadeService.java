package com.osapp.service;

import com.osapp.dao.CidadeDao;
import com.osapp.model.Cidade;
import com.osapp.model.Estado;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class CidadeService {

    public void adicionarCidade(String nome, Estado estado) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            CidadeDao dao = new CidadeDao(em);
            dao.salvar(new Cidade(nome, estado));
        } finally {
            em.close();
        }
    }

    public List<Cidade> listarCidades() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            CidadeDao dao = new CidadeDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarCidade(Cidade cidade) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            CidadeDao dao = new CidadeDao(em);
            dao.atualizar(cidade);
        } finally {
            em.close();
        }
    }

    public void deletarCidade(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            CidadeDao dao = new CidadeDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
