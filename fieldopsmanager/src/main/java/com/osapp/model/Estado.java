package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estados")
public class Estado implements Listar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sigla;

    public Estado(){

    }
    public Estado(String name, String sigla){
        this.name = name;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    @Override
    public String toString() {
        return this.name + " | " + this.sigla;
    }
}
