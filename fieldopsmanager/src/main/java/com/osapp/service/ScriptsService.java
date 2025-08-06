package com.osapp.service;

import com.osapp.dao.ScriptsDao;
import com.osapp.model.Scripts;
import com.osapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ScriptsService {

    public void adicionarScripts(Scripts scripts) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ScriptsDao dao = new ScriptsDao(em);
            dao.salvar(scripts);
        } finally {
            em.close();
        }
    }

    public List<Scripts> listarScripts() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ScriptsDao dao = new ScriptsDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarScripts(Scripts scripts) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ScriptsDao dao = new ScriptsDao(em);
            dao.atualizar(scripts);
        } finally {
            em.close();
        }
    }

    public void deletarScripts(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ScriptsDao dao = new ScriptsDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
