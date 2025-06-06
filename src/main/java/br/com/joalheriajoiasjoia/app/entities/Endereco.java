package br.com.joalheriajoiasjoia.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	// Atributos
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idEndereco", nullable = false)
		private Long idEndereco;
		
		@Column(name = "cep")
		private String cep;
		
		@Column(name = "rua", nullable = false, length = 100)
		private String rua;
		
		@Column(name = "bairro", nullable = false, length = 100)
		private String bairro;
		
		@Column(name = "numero", nullable = false, length = 50)
		private String numero;
		
		@Column(name = "cidade", nullable = false)
		private String cidade;
		
		@Column(name = "estado", unique = false)
		private String estado;
		
		@Column(name = "complemento")
		private String complemento;
		
		@ManyToOne
		@JsonIgnoreProperties
		@JoinColumn(name = "id_usuario")
		private Usuario usuario;

//Construtores
	public Endereco() {

	}
	public Endereco(Long idEndereco, String cep, String rua, String bairro, String numero, String cidade, String estado, String complemento) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Usuario getCliente() {
		return usuario;
	}
	public void setCliente(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}