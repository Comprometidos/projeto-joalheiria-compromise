package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoUsuario", nullable = false)
    private Long idTipoUsuario;
    
    @Column(name = "nomeTipoUsuario", nullable = false, length = 50)
    private String nomeTipoUsuario;

    // Getters e Setters
    public Long getIdTipoUsuario() { 
    	return idTipoUsuario; 
    }
    public void setIdTipoUsuario(Long idTipoUsuario) { 
    	this.idTipoUsuario = idTipoUsuario; 
    }
    
    public String getNomeTipoUsuario() { 
    	return nomeTipoUsuario; 
    }
    public void setNomeTipoUsuario(String NomeTipoUsuario) { 
    	this.nomeTipoUsuario = NomeTipoUsuario; 
    }
}
