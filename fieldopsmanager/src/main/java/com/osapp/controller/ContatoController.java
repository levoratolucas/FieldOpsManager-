package com.osapp.controller;

import com.osapp.model.Contato;
import com.osapp.service.ContatoService;

import java.util.List;

public class ContatoController {

    private final ContatoService service = new ContatoService();

    public void adicionarContato(Contato contato) {
        service.adicionarContato(contato);
    }

    public List<Contato> listarContatos() {
        return service.listarContatos();
    }

    public void atualizarContato(Contato contato) {
        service.atualizarContato(contato);
    }

    public void deletarContato(Long id) {
        service.deletarContato(id);
    }
}
