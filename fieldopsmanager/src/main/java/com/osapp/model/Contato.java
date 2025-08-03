package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contatoes")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Contato() {
    }

    public Contato(String name, String telefone, Cliente cliente) {
        this.name = name;
        this.telefone = telefone;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
