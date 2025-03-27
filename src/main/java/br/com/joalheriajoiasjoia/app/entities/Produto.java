package br.com.joalheriajoiasjoia.app.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto", nullable = false)
    private Long idProduto;

    @Column(name = "nomeProduto", nullable = false, length = 100)
    private String nomeProduto;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private CategoriaProduto categoria;

    @ManyToOne
    @JoinColumn(name = "idTipo", nullable = false)
    private TipoProduto tipo;

    @ManyToMany
    @JoinTable(
        name = "tb_produto_ornamento",
        joinColumns = @JoinColumn(name = "idProduto"),
        inverseJoinColumns = @JoinColumn(name = "idOrnamentos")
    )
    private Set<Ornamentos> pedras; // Este é o campo referenciado no mappedBy

    // Construtores
    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, CategoriaProduto categoria, TipoProduto tipo,  Set<Ornamentos> pedras) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.tipo = tipo;
        this.pedras = pedras;
    }

    // Getters e Setters
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public Set<Ornamentos> getPedras() {
        return pedras;
    }

    public void setPedras(Set<Ornamentos> pedras) {
        this.pedras = pedras;
    }
}