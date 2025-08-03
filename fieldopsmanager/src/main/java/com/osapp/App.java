package com.osapp;

import com.osapp.controller.ColaboradorController;
import com.osapp.model.Colaborador;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ColaboradorController controller = new ColaboradorController(em);

        try {
            em.getTransaction().begin();

            controller.adicionarColaborador("Izabella Santos", "Compras");

            List<Colaborador> lista = controller.listarColaboradores();
            for (Colaborador c : lista) {
                System.out.println("ID: " + c.getId() + " | Nome: " + c.getName() + " | Cargo: " + c.getCargo());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JpaUtil.close();
        }
    }
}
