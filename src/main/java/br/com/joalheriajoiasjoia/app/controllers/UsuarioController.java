package br.com.joalheriajoiasjoia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joalheriajoiasjoia.app.entities.Usuario;
import br.com.joalheriajoiasjoia.app.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
    @Autowired
    private UsuarioService service;

    // Criar uma nova pessoa
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvarUsuario(usuario);
    }
    
    // Buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
    	return service.buscarPorId(id);
    }
    
    // Excluir uma pessoa
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletarUsuario(id);
    }
 // Listar todas as pessoas
    @GetMapping
    public List<Usuario> listarTodas() {
        return service.listarUsuarios();
    }

    // Buscar pessoa por email
    @GetMapping("/email/{email}")
    public Usuario buscarPorEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    //Metodo de login
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario loginRequest) {
    	
    	//Chama o serviço para verificar as credenciais
    	Usuario usuario = service.autenticarUsuario(loginRequest.getEmail(), loginRequest.getSenha());
    	
    	if (usuario != null) {
    		return usuario;
    	} else {
    		return null;
    	}
    	
    }
}
