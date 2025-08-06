package com.osapp.service;

import com.osapp.dao.ClienteDao;
import com.osapp.model.Cliente;
import com.osapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteService {

    public void adicionarCliente(String name, Cliente cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ClienteDao dao = new ClienteDao(em);
            dao.salvar(cliente);
        } finally {
            em.close();
        }
    }

    public List<Cliente> listarClientes() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ClienteDao dao = new ClienteDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarCliente(Cliente cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ClienteDao dao = new ClienteDao(em);
            dao.atualizar(cliente);
        } finally {
            em.close();
        }
    }

    public void deletarCliente(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            ClienteDao dao = new ClienteDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
}
