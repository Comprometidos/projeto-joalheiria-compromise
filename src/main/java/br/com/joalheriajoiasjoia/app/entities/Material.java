package br.com.joalheriajoiasjoia.app.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaterial", nullable = false)
    private Long idMaterial;

    @Column(name = "nomeMaterial", nullable = false, length = 100)
    private String nomeMaterial;

    @OneToMany(mappedBy = "material")
    private Set<Produto> produtos;

    // Construtores
    public Material() {
    }

    public Material(Long idMaterial, String nomeMaterial) {
        this.idMaterial = idMaterial;
        this.nomeMaterial = nomeMaterial;
    }

    // Getters e Setters
    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}