package br.com.joalheriajoiasjoia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joalheriajoiasjoia.app.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//Consulta para encontrar o nome de usuario
	Usuario findByNomeUsuario(String nomeUsuario);
	
	//Consulta para encontrar por email
	Usuario findByEmail(String email);

}