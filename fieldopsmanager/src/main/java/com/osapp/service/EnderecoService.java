package com.osapp.service;

import com.osapp.dao.EnderecoDao;
import com.osapp.model.Cidade;
import com.osapp.model.Endereco;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EnderecoService {

    public void adicionarEndereco(String rua, String bairro, String numero, Cidade cidade) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EnderecoDao dao = new EnderecoDao(em);
            dao.salvar(new Endereco(rua, bairro, numero, cidade));
        } finally {
            em.close();
        }
    }

    public List<Endereco> listarEnderecos() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EnderecoDao dao = new EnderecoDao(em);
            return dao.listarTodos();
        } finally {
            em.close();
        }
    }

    public void atualizarEndereco(Endereco endereco) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EnderecoDao dao = new EnderecoDao(em);
            dao.atualizar(endereco);
        } finally {
            em.close();
        }
    }

    public void deletarEndereco(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EnderecoDao dao = new EnderecoDao(em);
            dao.deletar(id);
        } finally {
            em.close();
        }
    }
    public Endereco getEndereco(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Endereco endereco;
        try {
            EnderecoDao dao = new EnderecoDao(em);
            endereco = dao.buscarPorId(id);
        } finally {
            em.close();
        }
        return endereco;
    }
}
