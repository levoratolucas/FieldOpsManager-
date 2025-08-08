package com.osapp.menuTesteBackend;

import java.util.List;

import java.util.Scanner;

import com.osapp.controller.*;
import com.osapp.model.Cidade;
import com.osapp.model.Estado;

public class CadastroTeste {

    public static final Scanner scanner = new Scanner(System.in);

    public static CidadeController cidadeController = new CidadeController();
    public static ClienteController clienteController = new ClienteController();
    public static ColaboradorController colaboradorController = new ColaboradorController();
    public static ContatoController contatoController = new ContatoController();
    public static EnderecoController enderecoController = new EnderecoController();
    public static EquipamentoController equipamentoController = new EquipamentoController();
    public static EstadoController estadoController = new EstadoController();
    public static OsController osController = new OsController();
    public static ScriptsController scriptsController = new ScriptsController();

    public static void cadastrarEndereco(EnderecoController enderecoController, CidadeController cidadeController,
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
            ListarTeste.listarCidades(cidades);

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

    public static void cadastrarEstado(EstadoController controller) {
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

    

    public static Cidade cadastrarCidade(CidadeController cidadeController, EstadoController estadoController) {
        System.out.println("Qual o nome da cidade? ");
        String name = scanner.nextLine();

        // Lista os estados disponíveis
        ListarTeste.listarEstados(estadoController.listarEstados());

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
                        ListarTeste.listarEstados(estadoController.listarEstados());
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

    static void cadastroColaborador(ColaboradorController controller) {
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

}
