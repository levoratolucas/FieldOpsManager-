package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String tipo;

    public Equipamento(){

    }
    public Equipamento(String name, String tipo){
        this.name = name;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
