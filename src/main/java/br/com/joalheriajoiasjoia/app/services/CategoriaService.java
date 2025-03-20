package br.com.joalheriajoiasjoia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.CategoriaProduto;
import br.com.joalheriajoiasjoia.app.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Retorna todas as categorias
    public List<CategoriaProduto> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // Retorna uma categoria pelo ID
    public CategoriaProduto getCategoriaById(Long id) {
        Optional<CategoriaProduto> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    // Salva uma nova categoria
    public CategoriaProduto saveCategoria(CategoriaProduto categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualiza uma categoria existente
    public CategoriaProduto updateCategoria(Long id, CategoriaProduto categoriaDetails) {
        Optional<CategoriaProduto> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
        	CategoriaProduto categoria = categoriaOptional.get();
            categoria.setNomeCategoria(categoriaDetails.getNomeCategoria());
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    // Deleta uma categoria pelo ID
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}