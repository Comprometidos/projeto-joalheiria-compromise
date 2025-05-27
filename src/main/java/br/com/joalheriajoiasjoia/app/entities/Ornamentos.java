package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_ornamentos")
public class Ornamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrnamentos", nullable = false)
    private Long idOrnamentos;

    @Column(name = "nomeOrnamentos", nullable = false, length = 100)
    private String nomeOrnamento;

    // Construtores
    public Ornamentos() {
    }

    public Ornamentos(Long idOrnamentos, String nomeOrnamento) {
        this.idOrnamentos = idOrnamentos;
        this.nomeOrnamento = nomeOrnamento;
    }

    // Getters e Setters
    public Long getIdOrnamentos() {
        return idOrnamentos;
    }

    public void setIdOrnamentos(Long idOrnamentos) {
        this.idOrnamentos = idOrnamentos;
    }

    public String getNomeOrnamento() {
        return nomeOrnamento;
    }

    public void setNomeOrnamento(String nomeOrnamento) {
        this.nomeOrnamento = nomeOrnamento;
    }

}