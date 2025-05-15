package br.com.joalheriajoiasjoia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Usuario;
import br.com.joalheriajoiasjoia.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    //Criar uma nova pessoa
    public Usuario salvarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }
    
    //Buscar todas pessoa por ID
  	public Usuario buscarPorId(Long id) {
  		return repository.findById(id).orElse(null);
  	}
  	
    //Listar todas as pessoas
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }
    
	//Deletar uma pessoa pelo ID
    public void deletarUsuario(Long id) {
        repository.deleteById(id);
    }
  //Verificar email e senha
  	public Usuario autenticarUsuario(String email, String senha) {
  		
  		//Verificar existência do email
  		Usuario usuario = repository.findByEmail(email);
  		
  		if (usuario != null && usuario.getSenha().equals(senha)) {
  			return usuario;
  		} else {
  			return null;
  		}
  	}

  	public Usuario findByEmail(String email) {
  		return null;
  	}
}