package com.osapp.menuTesteBackend;

import java.util.List;

import com.osapp.model.Cidade;
import com.osapp.model.Cliente;
import com.osapp.model.Colaborador;
import com.osapp.model.Estado;

public class ListarTeste {

    public static void listarEstados(List<Estado> estados) {
        estados.forEach(e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getSigla()));
    }

    public static void listarCidades(List<Cidade> cidades) {
        cidades.forEach(c -> System.out.println(c.getId() + " - " + c.getName()));
    }

    public static void listarColaboradores(List<Colaborador> colaboradores){
        colaboradores.forEach(c -> System.out.println(c.getId()+"- Nome: "+c.getName()+" RE: "+c.getRe()));
    }
    public static void listarClientes(List<Cliente> clientes){
        clientes.forEach(c -> System.out.println(c.getId()+"- Nome: "+c.getName()));
    }
}
