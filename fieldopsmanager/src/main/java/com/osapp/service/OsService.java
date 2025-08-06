package com.osapp.service;

import com.osapp.dao.OsDao;
import com.osapp.model.OS;
import com.osapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OsService {

    public void adicionarOs(OS os) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            OsDao dao = new OsDao(em);
            dao.salvar(os);
        } finally {
            em.close();
        }
    }

    public List<OS> listarOs() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            OsDao dao = new OsDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarOs(OS os) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            OsDao dao = new OsDao(em);
            dao.atualizar(os);
        } finally {
            em.close();
        }
    }

    public void deletarOs(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            OsDao dao = new OsDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
