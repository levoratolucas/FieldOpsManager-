package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String bairro;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String rua,String bairro, String numero, Cidade cidade) {
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
