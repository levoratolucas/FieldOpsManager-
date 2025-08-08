package com.osapp.controller;

import com.osapp.model.Cidade;
import com.osapp.model.Endereco;
import com.osapp.service.EnderecoService;

import java.util.List;

public class EnderecoController {

    private final EnderecoService service = new EnderecoService();

    public void adicionarEndereco(String rua, String bairro, String numero, Cidade cidade) {
        service.adicionarEndereco(rua, bairro, numero, cidade);
    }

    public List<Endereco> listarEnderecos() {
        return service.listarEnderecos();
    }

    public void atualizarEndereco(Endereco endereco) {
        service.atualizarEndereco(endereco);
    }

    public void deletarEndereco(Long id) {
        service.deletarEndereco(id);
    }
    public Endereco getEndereco(Long id){
        return service.getEndereco(id);
    }
}
