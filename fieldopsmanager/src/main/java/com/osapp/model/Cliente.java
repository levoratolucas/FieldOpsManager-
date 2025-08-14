package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente implements Listar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Cliente() {}

    public Cliente(String name) {
        this.name = name;
        
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

     @Override
    public String toString() {
        return this.name;
    }

}

