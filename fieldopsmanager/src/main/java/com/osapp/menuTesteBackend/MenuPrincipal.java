package com.osapp.menuTesteBackend;

import com.osapp.controller.*;
import com.osapp.model.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public void menu() {
        // CidadeController cidadeController = new CidadeController();
        ClienteController clienteController = new ClienteController();
        ColaboradorController colaboradorController = new ColaboradorController();
        // ContatoController contatoController = new ContatoController();
        // EnderecoController enderecoController = new EnderecoController();
        // EquipamentoController equipamentoController = new EquipamentoController();
        // EstadoController estadoController = new EstadoController();
        // OsController osController = new OsController();
        // ScriptsController scriptsController = new ScriptsController();

        // Cadastro da Ordem de Serviço
        System.out.println("=== Cadastro de Ordem de Serviço ===");
        System.out.println("=== Qual o ID do colaborador? ===");

        List<Colaborador> colaboradores = colaboradorController.listarColaboradores();

        ListarTeste.listarColaboradores(colaboradores);

        String csIdStr = scanner.nextLine();

        try {
            Long csId = Long.parseLong(csIdStr); // Conversão correta
            Colaborador cs = colaboradorController.getColaborador(csId);

            if (cs != null) {
                 System.out.println(cs.getId()+"- Nome: "+cs.getName()+" RE: "+cs.getRe());
            } else {
                System.out.println("Colaborador com ID " + csId + " não encontrado.");
                System.out.println("Cadastre um novo Colaborador");
                CadastroTeste.cadastroColaborador(colaboradorController);
            }

        } catch (NumberFormatException e) {
            System.out.println("ID inválido! Digite um número.");
        }

        // Selecionar cliente
        System.out.println("Qual o Cliente? Selecione pelo ID:");
        List<Cliente> clientes = clienteController.listarClientes();

        ListarTeste.listarClientes(clientes);

        // String clienteIdStr = scanner.nextLine();
        try {
            // Long clienteId = Long.parseLong(clienteIdStr);
            // Cliente cliente = clienteController.getCliente(clienteId);
            // if (cliente != null) {
            // nameId(cliente.getName(), cliente.getId(), "Cliente");
            // } else {
            // System.out.println("Cliente com ID " + clienteId + " não encontrado.");
            // // Aqui você pode chamar um método para cadastrar cliente, se quiser
            // }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido para cliente.");
        }

        // Continue daqui para cadastrar OS, equipamentos, etc.
    }

    public void cadastrarEndereco(EnderecoController enderecoController, CidadeController cidadeController,EstadoController estadoController){
        CadastroTeste.cadastrarEndereco(enderecoController, cidadeController, estadoController);
    }

    

}
