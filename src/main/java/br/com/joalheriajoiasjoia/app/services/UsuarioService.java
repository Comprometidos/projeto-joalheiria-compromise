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
  		return repository.findById(id).get();
  	}
  	
    //Listar todas as pessoas
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }
    
	//Deletar uma pessoa pelo ID
    public void deletarUsuario(Long id) {
        repository.deleteById(id);
    }
    
  	public Usuario findByUsuario(String nomeUsuario) {
  		return repository.findByNomeUsuario(nomeUsuario);
  	}
    
  	//Verificar email e senha
  	public Usuario autenticarUsuario(String email, String senha) {
  		
		//Buscar no Banco de Dados um Usuario que tenha o email informado
  		Usuario usuario = repository.findByEmail(email);
  		
		//Verifica se o usuario foi encontrado e se a senha confere com a senha do usuario
  		if (usuario != null && usuario.getSenha().equals(senha)) {
  			//Se email e senha estiverem corretos, retorna o objetoUsuario autenticado
  			return usuario;
  		} else {
			//Se o usuário não existir ou a senha não estiver correta, retorna null(falha na autenticação)
  			return null;
  		}
  		
  	}
}
