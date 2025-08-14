package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ordem_servicos")
public class OS implements Listar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String OS;

    @Lob
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    public OS() {}

    public OS(String OS, String comentarios, Cliente cliente, Colaborador colaborador) {
        this.OS = OS;
        this.comentarios = comentarios;
        this.cliente = cliente;
        this.colaborador = colaborador;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOS() {
        return OS;
    }

    public void setName(String OS) {
        this.OS = OS;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    @Override
    public String toString() {
        return "OS: " + this.OS +
               " | Cliente: " + (cliente != null ? cliente.getName() : "N/A") +
               " | Colaborador: " + (colaborador != null ? colaborador.getName() : "N/A") +
               " | Comentários: " + (comentarios != null ? comentarios : "");
    }
}
