package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade() {}

    public Cidade(String name, Estado estado) {
        this.name = name;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
