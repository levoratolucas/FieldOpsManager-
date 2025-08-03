package com.osapp;

import com.osapp.controller.ColaboradorController;
import com.osapp.service.ColaboradorService;
import com.osapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ColaboradorController controller = new ColaboradorController(em);
        ColaboradorService service = new ColaboradorService(controller);
        Scanner scanner = new Scanner(System.in);

        try {
            boolean running = true;

            while (running) {
                System.out.println("\n== Menu de Colaboradores ==");
                System.out.println("1. Adicionar colaborador");
                System.out.println("2. Listar colaboradores");
                System.out.println("3. Buscar colaborador por ID");
                System.out.println("4. Atualizar colaborador");
                System.out.println("5. Deletar colaborador");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                em.getTransaction().begin();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("RE: ");
                        String RE = scanner.nextLine();
                        service.criarColaborador(nome, RE);
                        break;
                    case 2:
                        service.listarColaboradores();
                        break;
                    case 3:
                        System.out.print("ID do colaborador: ");
                        Long idBusca = Long.parseLong(scanner.nextLine());
                        service.buscarColaborador(idBusca);
                        break;
                    case 4:
                        System.out.print("ID do colaborador: ");
                        Long idAtualiza = Long.parseLong(scanner.nextLine());
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo RE: ");
                        String novoRE = scanner.nextLine();
                        service.atualizarColaborador(idAtualiza, novoNome, novoRE);
                        break;
                    case 5:
                        System.out.print("ID do colaborador a deletar: ");
                        Long idDelete = Long.parseLong(scanner.nextLine());
                        service.excluirColaborador(idDelete);
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                em.getTransaction().commit();
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JpaUtil.close();
            scanner.close();
        }
    }
}
