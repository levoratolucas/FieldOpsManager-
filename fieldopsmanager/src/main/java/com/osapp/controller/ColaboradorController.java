package com.osapp.controller;

import com.osapp.model.Colaborador;
import com.osapp.service.ColaboradorService;

import java.util.List;

public class ColaboradorController {

    private final ColaboradorService service = new ColaboradorService();

    public void adicionarColaborador(String nome, String cargo) {
        service.adicionarColaborador(nome, cargo);
    }

    public List<Colaborador> listarColaboradores() {
        return service.listarColaboradores();
    }

    public void atualizarColaborador(Colaborador colaborador) {
        service.atualizarColaborador(colaborador);
    }

    public void deletarColaborador(Long id) {
        service.deletarColaborador(id);
    }
}
