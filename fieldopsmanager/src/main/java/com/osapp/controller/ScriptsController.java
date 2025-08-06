package com.osapp.controller;

import com.osapp.model.Scripts;
import com.osapp.service.ScriptsService;

import java.util.List;

public class ScriptsController {

    private final ScriptsService service = new ScriptsService();

    public void adicionarScripts(Scripts scripts) {
        service.adicionarScripts(scripts);
    }

    public List<Scripts> listarScripts() {
        return service.listarScripts();
    }

    public void atualizarScripts(Scripts scripts) {
        service.atualizarScripts(scripts);
    }

    public void deletarScripts(Long id) {
        service.deletarScripts(id);
    }
}
