package br.com.joalheriajoiasjoia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.joalheriajoiasjoia.app.entities.Usuario;
import br.com.joalheriajoiasjoia.app.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
    @Autowired
    private UsuarioService service;
    
    //Listar todas as pessoas
    @GetMapping
    public List<Usuario> listarTodas() {
        return service.listarUsuarios();
    }
    
    // Buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
    	return service.buscarPorId(id);
    }
    
    // Criar uma nova pessoa
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvarUsuario(usuario);
    }
    
    // Deletar uma pessoa
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletarUsuario(id);
    }
    
	//Buscar por nome de usuario 
	@GetMapping("/buscarpornomeusuario")
	public Usuario getByUsuario (@RequestParam String nomeUsuario) {
		return service.findByUsuario(nomeUsuario);
	}

    //Metodo de login
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario loginRequest) {
    	
		//Chama o metodo de autenticação do service passando o email e senha fornecido no login
		//1. loginRequest.getEmail()- obtem o email enviado pelo usuario da requisição 
		//2. loginRequest.getSenha() - Obtem a senha enviada pelo usuario na requisição
		//3. UsuarioService.autenticarPessoa(Email, senha) -  verifica no banco se existe um usuario com este email e se a senha é valida 
		//4. Retorna o objeto usuarioautenticado, ou null caso falhe na autenticação 
    	Usuario usuario = service.autenticarUsuario(loginRequest.getEmail(), loginRequest.getSenha());
    	
		//Verifica se o serviço retornou um usuario válido (autenticação bem-sucedida)
    	if (usuario != null) {
    		//Se autenticado, retorna os dados do usuario
    		return usuario;
    	} else {
			//Se não atenticado, retorna null indicando falha no login
    		return null;
    	}
    	
    }
}
