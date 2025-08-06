package com.osapp.menuTesteBackend;

import com.osapp.controller.*;
import com.osapp.model.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start(String[] args) {
        CidadeController cidadeController = new CidadeController();
        ClienteController clienteController = new ClienteController();
        ColaboradorController colaboradorController = new ColaboradorController();
        ContatoController contatoController = new ContatoController();
        EnderecoController enderecoController = new EnderecoController();
        EquipamentoController equipamentoController = new EquipamentoController();
        EstadoController estadoController = new EstadoController();
        OSController osController = new OSController();
        ScriptsController scriptsController = new ScriptsController();


        System.out.println("=== Cadastro de Ordem de Serviço ===");

        // 1. Escolher ou cadastrar cliente
        Cliente cliente = escolherOuCadastrarCliente(clienteController);

        // 2. Escolher ou cadastrar equipamento
        Equipamento equipamento = escolherOuCadastrarEquipamento(equipamentoController);

        // 3. Inserir nome e comentários da OS
        System.out.print("Digite um nome para a OS: ");
        String nomeOs = scanner.nextLine();

        System.out.print("Digite os comentários da OS: ");
        String comentarios = scanner.nextLine();

        // 4. Colaborador fixo (id = 1)
        Colaborador colaborador = colaboradorController.buscarPorId(1L);
        if (colaborador == null) {
            System.out.println("Colaborador com ID 1 não encontrado. Verifique o banco de dados.");
            return;
        }

        // 5. Criar e salvar OS
        OS os = new OS(nomeOs, comentarios, cliente, colaborador);
        osController.adicionarOS(os);

        // 6. Adicionar script para o equipamento na OS
        System.out.println("Digite o script (pode colar o conteúdo):");
        String script = scanner.nextLine();

        System.out.println("Digite um comentário sobre o script:");
        String comentarioScript = scanner.nextLine();

        Scripts scripts = new Scripts(script, comentarioScript, equipamento, os);
        scriptsController.adicionarScripts(scripts);

        System.out.println("Ordem de serviço cadastrada com sucesso!");
    }

    private static Cliente escolherOuCadastrarCliente(ClienteController controller) {
        System.out.println("\nDeseja (1) Escolher cliente existente ou (2) Cadastrar novo?");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            List<Cliente> clientes = controller.listarClientes();
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado. Será necessário cadastrar um.");
                return cadastrarCliente(controller);
            }
            clientes.forEach(c -> System.out.println(c.getId() + " - " + c.getName()));
            System.out.print("Digite o ID do cliente: ");
            Long id = Long.parseLong(scanner.nextLine());
            return controller.buscarPorId(id);
        } else {
            return cadastrarCliente(controller);
        }
    }

    private static Cliente cadastrarCliente(ClienteController controller) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        // Endereço fixo temporário ou você pode estender aqui
        Endereco endereco = new Endereco("Rua Exemplo", "123", null); // cidade null por enquanto
        Cliente cliente = new Cliente(nome, endereco);
        controller.adicionarCliente(cliente);

        return cliente;
    }

    private static Equipamento escolherOuCadastrarEquipamento(EquipamentoController controller) {
        System.out.println("\nDeseja (1) Escolher equipamento existente ou (2) Cadastrar novo?");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            List<Equipamento> equipamentos = controller.listarEquipamentos();
            if (equipamentos.isEmpty()) {
                System.out.println("Nenhum equipamento cadastrado. Será necessário cadastrar um.");
                return cadastrarEquipamento(controller);
            }
            equipamentos.forEach(e -> System.out.println(e.getId() + " - " + e.getName()));
            System.out.print("Digite o ID do equipamento: ");
            Long id = Long.parseLong(scanner.nextLine());
            return controller.buscarPorId(id);
        } else {
            return cadastrarEquipamento(controller);
        }
    }

    private static Equipamento cadastrarEquipamento(EquipamentoController controller) {
        System.out.print("Nome do equipamento: ");
        String nome = scanner.nextLine();

        System.out.print("Tipo do equipamento: ");
        String tipo = scanner.nextLine();

        Equipamento equipamento = new Equipamento(nome, tipo);
        controller.adicionarEquipamento(equipamento);

        return equipamento;
    }
}
