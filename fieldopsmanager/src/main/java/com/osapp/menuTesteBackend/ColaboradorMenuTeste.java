package com.osapp.menuTesteBackend;

import java.util.Scanner;

import com.osapp.controller.ColaboradorController;

public class ColaboradorMenuTeste {

    private static final Scanner scanner = new Scanner(System.in);
    private static ColaboradorController colaboradorController;

    public static void menu() {

        int key = -1;

        do {

            colaboradorController = new ColaboradorController();

            System.out.println("########### COLABORADOR MENU ###########");
            System.out.println("1 ------ Cadastrar colaborador  ------ 1");
            System.out.println("2 --------Listar Colabordores -------- 2");
            System.out.println("3 -------------- Editar -------------- 3");
            System.out.println("0 --------------Encerrar ------------- 0");
            key = scanner.nextInt();

            switch (key) {
                case 1:
                    CadastroTeste.cadastroColaborador(colaboradorController);
                    break;
                case 2:
                    ListarTeste.listarColaboradores(colaboradorController);
                    System.out.println("\n\n\n");
                    break;
                
                    case 3:

                    System.out.println("Qual colaborador da lista precisa editar?");
                    ListarTeste.listarColaboradores(colaboradorController);
                    System.out.println("#################################");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Qual o nome editado?");
                    String name = scanner.nextLine();
                    System.out.println("Qual o RE editado?");
                    String RE = scanner.nextLine();
                    colaboradorController.updateColaborador(id, name, RE);
                    ListarTeste.listarColaboradores(colaboradorController);

                default:
                    System.out.println("#################################");
                    System.out.println("### OBRIGADO PELA PREFERENCIA ###");
                    System.out.println("#################################");
                    break;
            }
        } while (key != 0);
    }

}

