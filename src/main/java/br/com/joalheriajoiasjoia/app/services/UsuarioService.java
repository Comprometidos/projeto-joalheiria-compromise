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

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        usuario.setIdUsuario(id);
        return repository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        repository.deleteById(id);
    }
}