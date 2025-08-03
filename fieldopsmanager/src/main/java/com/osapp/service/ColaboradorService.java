package com.osapp.service;

import com.osapp.controller.ColaboradorController;
import com.osapp.model.Colaborador;

import java.util.List;

public class ColaboradorService {
    private ColaboradorController controller;

    public ColaboradorService(ColaboradorController controller) {
        this.controller = controller;
    }

    public void criarColaborador(String nome, String RE) {
        controller.adicionarColaborador(nome, RE);
        System.out.println("Colaborador criado com sucesso.");
    }

    public void atualizarColaborador(Long id, String novoNome, String novoRE) {
        Colaborador existente = controller.buscarColaboradorPorId(id);
        if (existente != null) {
            existente.setName(novoNome);
            existente.setRe(novoRE);
            controller.adicionarColaborador(existente.getName(), existente.getRe()); // assume que salvar sobrescreve
            System.out.println("Colaborador atualizado.");
        } else {
            System.out.println("Colaborador com ID " + id + " não encontrado.");
        }
    }

    public void excluirColaborador(Long id) {
        controller.deletarColaborador(id);
        System.out.println("Colaborador excluído.");
    }

    public void listarColaboradores() {
        List<Colaborador> lista = controller.listarColaboradores();
        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado.");
        } else {
            for (Colaborador c : lista) {
                System.out.println("ID: " + c.getId() + " | Nome: " + c.getName() + " | RE: " + c.getRe());
            }
        }
    }

    public void buscarColaborador(Long id) {
        Colaborador c = controller.buscarColaboradorPorId(id);
        if (c != null) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getName() + " | RE: " + c.getRe());
        } else {
            System.out.println("Colaborador com ID " + id + " não encontrado.");
        }
    }
}
