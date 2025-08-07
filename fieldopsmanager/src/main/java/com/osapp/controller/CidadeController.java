package com.osapp.controller;

import com.osapp.model.Cidade;
import com.osapp.model.Estado;
import com.osapp.service.CidadeService;

import java.util.List;

public class CidadeController {

    private final CidadeService service = new CidadeService();

    public Cidade adicionarCidade(String nome, Estado estado) {
       return service.adicionarCidade(nome, estado);
    }

    public List<Cidade> listarCidades() {
        return service.listarCidades();
    }

    public void atualizarCidade(Cidade cidade) {
        service.atualizarCidade(cidade);
    }

    public void deletarCidade(Long id) {
        service.deletarCidade(id);
    }

    public Cidade getCidade(Long id) {
        return service.getCidade(id);
    }
}
