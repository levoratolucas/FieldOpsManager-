package com.osapp.util;

import jakarta.persistence.EntityManager;

public class TesteConexao {

    public static void main(String[] args) {
        System.out.println("Iniciando teste de conexão...");

        try {
            EntityManager em = JpaUtil.getEntityManager();

            em.getTransaction().begin();

            // Você pode fazer uma query simples, por exemplo, a consulta de uma entidade
            // Ou só abrir e fechar a transação para testar a conexão
            em.getTransaction().commit();

            em.close();

            System.out.println("Conexão com banco OK!");
        } catch (Exception e) {
            System.err.println("Erro na conexão com banco:");
            e.printStackTrace();
        } finally {
            JpaUtil.close();  // fecha o factory
        }
    }
}

