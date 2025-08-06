package com.osapp.controller;

import com.osapp.model.Estado;
import com.osapp.service.EstadoService;

import java.util.List;

public class EstadoController {

    private final EstadoService service = new EstadoService();

    public void adicionarEstado(String nome, String sigla) {
        service.adicionarEstado(nome, sigla);
    }

    public List<Estado> listarEstados() {
        return service.listarEstados();
    }

    public void atualizarEstado(Estado estado) {
        service.atualizarEstado(estado);
    }

    public void deletarEstado(Long id) {
        service.deletarEstado(id);
    }
}
