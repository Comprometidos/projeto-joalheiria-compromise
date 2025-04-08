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
    @JoinColumn(name = "idTipoProduto", nullable = false)
    private TipoProduto tipo;
    
    @ManyToOne
    @JoinColumn(name = "descricao_tipo_produto", nullable = false)
    private TipoProduto descricao;

    @ManyToOne
    @JoinColumn(name = "id_preco", nullable = false)
    private Produto preco;

    @ManyToOne
    @JoinColumn(name = "id_ornamentos", nullable = false)
    private Ornamentos ornamentos;

    // Construtores
    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, CategoriaProduto categoria, TipoProduto tipo, TipoProduto descricao, Produto preco, Ornamentos ornamentos) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
        this.ornamentos = ornamentos;
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

    public TipoProduto getDescricao() {
        return descricao;
    }

    public void setDescricao(TipoProduto descricao) {
        this.descricao = descricao;
    }

    public Produto getPreco() {
        return preco;
    }

    public void setPreco(Produto preco) {
        this.preco = preco;
    }

    public Ornamentos getOrnamentos() {
        return ornamentos;
    }

    public void setOrnamentos(Ornamentos ornamentos) {
        this.ornamentos = ornamentos;
    }
}