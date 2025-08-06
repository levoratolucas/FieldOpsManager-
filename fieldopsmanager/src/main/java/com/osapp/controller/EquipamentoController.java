package com.osapp.controller;

import com.osapp.model.Equipamento;
import com.osapp.service.EquipamentoService;

import java.util.List;

public class EquipamentoController {

    private final EquipamentoService service = new EquipamentoService();

    public void adicionarEquipamento(String name, String tipo) {
        service.adicionarEquipamento(name, tipo);
    }

    public List<Equipamento> listarEquipamentos() {
        return service.listarEquipamentos();
    }

    public void atualizarEquipamento(Equipamento equipamento) {
        service.atualizarEquipamento(equipamento);
    }

    public void deletarEquipamento(Long id) {
        service.deletarEquipamento(id);
    }
}
