package com.osapp.menuTesteBackend;

import com.osapp.controller.*;
import com.osapp.model.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public void menu() {
        CidadeController cidadeController = new CidadeController();
        ClienteController clienteController = new ClienteController();
        ColaboradorController colaboradorController = new ColaboradorController();
        ContatoController contatoController = new ContatoController();
        EnderecoController enderecoController = new EnderecoController();
        EquipamentoController equipamentoController = new EquipamentoController();
        EstadoController estadoController = new EstadoController();
        OsController osController = new OsController();
        ScriptsController scriptsController = new ScriptsController();

        // Cadastro da Ordem de Serviço
        System.out.println("=== Cadastro de Ordem de Serviço ===");
        System.out.println("=== Qual o ID do colaborador? ===");

        List<Colaborador> colaboradores = colaboradorController.listarColaboradores();

        colaboradores.forEach(c -> nameId(c.getName(), c.getId(), "Colaborador"));

        String csIdStr = scanner.nextLine();

        try {
            Long csId = Long.parseLong(csIdStr); // Conversão correta
            Colaborador cs = colaboradorController.getColaborador(csId);

            if (cs != null) {
                nameId(cs.getName(), cs.getId(), "Colaborador");
            } else {
                System.out.println("Colaborador com ID " + csId + " não encontrado.");
                System.out.println("Cadastre um novo Colaborador");
                cadastroColaborador(colaboradorController);
            }

        } catch (NumberFormatException e) {
            System.out.println("ID inválido! Digite um número.");
        }

        // Selecionar cliente
        System.out.println("Qual o Cliente? Selecione pelo ID:");
        List<Cliente> clientes = clienteController.listarClientes();
        clientes.forEach(cliente -> nameId(cliente.getName(), cliente.getId(), "Cliente"));

        String clienteIdStr = scanner.nextLine();
        try {
            Long clienteId = Long.parseLong(clienteIdStr);
            // Cliente cliente = clienteController.getCliente(clienteId);
            // if (cliente != null) {
            //     nameId(cliente.getName(), cliente.getId(), "Cliente");
            // } else {
            //     System.out.println("Cliente com ID " + clienteId + " não encontrado.");
            //     // Aqui você pode chamar um método para cadastrar cliente, se quiser
            // }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido para cliente.");
        }

        // Continue daqui para cadastrar OS, equipamentos, etc.
    }

    private void cadastroColaborador(ColaboradorController controller) {
        String name;
        String RE;
        String confirmado;
        do {
            System.out.println("Qual o Nome do Colaborador?");
            name = scanner.nextLine();
            System.out.println("Qual o RE?");
            RE = scanner.nextLine();
            System.out.println("Confirmar colaborador:");
            System.out.println("Nome: " + name);
            System.out.println("RE: " + RE);
            System.out.println("Correto? (S)(N)");
            confirmado = scanner.nextLine();
        } while (!confirmado.equalsIgnoreCase("S"));

        try {
            controller.adicionarColaborador(name, RE);
            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar colaborador: " + e.getMessage());
        }
    }

    private void nameId(String name, Long id, String tipo) {
        System.out.println(tipo + " selecionado: " + name + " | ID: " + id);
    }

    private void cadastrarEndereco() {
        // Em desenvolvimento
    }

    private void cadastrarCliente(ClienteController clienteController, EnderecoController enderecoController,
                                   CidadeController cidadeController, EstadoController estadoController) {
        String name;
        String OSNumb;
        System.out.println("Qual o nome do Cliente?");
        name = scanner.nextLine();
        System.out.println("Qual o número da OS?");
        OSNumb = scanner.nextLine();

        // Completar lógica de cadastro de cliente aqui
    }
}
