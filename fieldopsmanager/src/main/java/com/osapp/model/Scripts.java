package com.osapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "scripts")
public class Scripts implements Listar{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String script;

    @Lob
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private OS os;

    public Scripts() {}

    public Scripts(String script, String comentario, Equipamento equipamento, OS os) {
        this.script = script;
        this.comentario = comentario;
        this.equipamento = equipamento;
        this.os = os;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
    @Override
    public String toString() {
        return "Script: " + (script != null ? script : "") +
               " | Comentário: " + (comentario != null ? comentario : "") +
               " | Equipamento: " + (equipamento != null ? equipamento.getName() : "N/A") +
               " | OS: " + (os != null ? os.getOS() : "N/A");
    }
}
