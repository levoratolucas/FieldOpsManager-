package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String re;

    // Construtor vazio exigido pelo JPA
    public Colaborador() {}

    // Construtor com parâmetros
    public Colaborador(String name, String re) {
        this.name = name;
        this.re = re;
    }

    // Getters e Setters
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

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }
}
