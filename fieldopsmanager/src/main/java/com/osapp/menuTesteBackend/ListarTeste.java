package com.osapp.menuTesteBackend;

import java.util.List;

import com.osapp.controller.CidadeController;
import com.osapp.controller.ClienteController;
import com.osapp.controller.ColaboradorController;
import com.osapp.controller.EstadoController;
import com.osapp.model.Cidade;
import com.osapp.model.Cliente;
import com.osapp.model.Colaborador;
import com.osapp.model.Estado;

public class ListarTeste {

    public static void listarEstados(EstadoController controller) {
        List<Estado> estados = controller.listarEstados();
        estados.forEach(e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getSigla()));
    }

    public static void listarCidades(CidadeController controller) {
        List<Cidade> cidades = controller.listarCidades();
        cidades.forEach(c -> System.out.println(c.getId() + " - " + c.getName()));
    }

    public static void listarColaboradores(ColaboradorController controller) {
        List<Colaborador> colaboradores = controller.listarColaboradores();
        colaboradores.forEach(c -> System.out.println(c.getId() + "- Nome: " + c.getName() + " RE: " + c.getRe()));
    }

    public static void listarClientes(ClienteController controller) {
        List<Cliente> clientes = controller.listarClientes();
        clientes.forEach(c -> System.out.println(c.getId() + "- Nome: " + c.getName()));
    }
}
