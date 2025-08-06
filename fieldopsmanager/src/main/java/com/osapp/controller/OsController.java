package com.osapp.controller;

import com.osapp.model.OS;
import com.osapp.service.OsService;

import java.util.List;

public class OsController {

    private final OsService service = new OsService();

    public void adicionarOs(OS os) {
        service.adicionarOs(os);
    }

    public List<OS> listarOs() {
        return service.listarOs();
    }

    public void atualizarOs(OS os) {
        service.atualizarOs(os);
    }

    public void deletarOs(Long id) {
        service.deletarOs(id);
    }
}
