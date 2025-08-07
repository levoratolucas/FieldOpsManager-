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

    public void cadastrarEndereco(EnderecoController enderecoController, CidadeController cidadeController,
            EstadoController estadoController) {
        Cidade cidade = null;

        // Loop até que uma cidade válida seja fornecida (encontrada ou cadastrada)
        while (cidade == null) {
            System.out.println("Qual a Rua?");
            String rua = scanner.nextLine();

            System.out.println("Qual o bairro?");
            String bairro = scanner.nextLine();

            System.out.println("Qual o número?");
            String numero = scanner.nextLine();

            List<Cidade> cidades = cidadeController.listarCidades();
            System.out.println("Qual cidade da lista?");
            cidades.forEach(c -> System.out.println(c.getId() + " - " + c.getName()));

            String idCidade = scanner.nextLine();

            try {
                Long idLong = Long.parseLong(idCidade);
                Cidade cs = cidadeController.getCidade(idLong);

                if (cs != null) {
                    System.out.println(cs.getId() + " - " + cs.getName() + " - " + cs.getEstado().getSigla());
                    cidade = cs;
                } else {
                    System.out.println("Cidade com ID " + idLong + " não encontrada.");
                    System.out.println("Deseja cadastrar uma nova cidade? (s/n)");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        cidade = cadastrarCidade(cidadeController, estadoController);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("ID inválido! Digite um número.");
            }

            if (cidade != null) {
                // Cidade válida, prossegue com cadastro de endereço
                enderecoController.adicionarEndereco(rua, bairro, numero, cidade);
                System.out.println("Endereço cadastrado com sucesso!");
            }
        }
    }

    private void cadastrarEstado(EstadoController controller) {
        String name;
        String sigla;
        System.out.println("Qual o estado?");
        name = scanner.nextLine();
        System.out.println("Qual a sigla?");
        sigla = scanner.nextLine();
        try {
            controller.adicionarEstado(name, sigla);
            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Erro a cadastrar -> " + e.getMessage());
        }

    }

    private Cidade cadastrarCidade(CidadeController cidadeController, EstadoController estadoController) {
        System.out.println("Qual o nome da cidade? ");
        String name = scanner.nextLine();

        // Lista os estados disponíveis
        List<Estado> estados = estadoController.listarEstados();
        estados.forEach(e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getSigla()));

        Estado estado = null;

        while (estado == null) {
            System.out.println("Digite o ID do estado correspondente:");
            String idEstado = scanner.nextLine();

            try {
                Long id = Long.parseLong(idEstado);
                estado = estadoController.getEstado(id);

                if (estado == null) {
                    System.out.println("Estado não encontrado. Deseja cadastrar um novo estado? (s/n)");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        cadastrarEstado(estadoController);
                        // Atualiza a lista de estados
                        estados = estadoController.listarEstados();
                        estados.forEach(
                                e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getSigla()));
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("ID inválido! Digite um número.");
            }
        }

        // Cria e adiciona a cidade
        Cidade cidade = cidadeController.adicionarCidade(name, estado);
        System.out.println("Cidade cadastrada com sucesso!");
        return cidade;
    }

}
