package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Long idProduto;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(name = "ornamentos", nullable = false)
    private String ornamentos;
    
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "tipo_produto", nullable = false)
    private String tipo;

    @Column(name = "preco", nullable = false)
    private double preco;
    
    @Column(name = "imgUrl", nullable = false)
    private String imgUrl;
    
    // Construtores
    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, String categoria, String tipo, String descricao, double preco, Stirng imgUrl,String ornamentos) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.tipo = tipo;
        this.preco = preco;
        this.imgUrl = imgUrl;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getImgUrl() {
    	return imgUrl;
    }
    
    public void setImgrUrl(String imgUrl) {
    	this.imgUrl = imgUrl;
    }

    public String getOrnamentos() {
        return ornamentos;
    }

    public void setOrnamentos(String ornamentos) {
        this.ornamentos = ornamentos;
    }
}