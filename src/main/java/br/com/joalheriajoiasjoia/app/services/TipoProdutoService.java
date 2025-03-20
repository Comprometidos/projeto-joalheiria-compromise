package br.com.joalheriajoiasjoia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.TipoProduto;
import br.com.joalheriajoiasjoia.app.repositories.TipoProdutoRepository;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoRepository;

    // Retorna todos os tipos
    public List<TipoProduto> getAllTipos() {
        return tipoRepository.findAll();
    }

    // Retorna um tipo pelo ID
    public TipoProduto getTipoById(Long id) {
        Optional<TipoProduto> tipo = tipoRepository.findById(id);
        return tipo.orElse(null);
    }

    // Salva um novo tipo
    public TipoProduto saveTipo(TipoProduto tipo) { 
        return tipoRepository.save(tipo);
    }

    // Atualiza um tipo existente
    public TipoProduto updateTipo(Long id, TipoProduto tipoDetails) { 
        Optional<TipoProduto> tipoOptional = tipoRepository.findById(id);
        if (tipoOptional.isPresent()) {
            TipoProduto tipo = tipoOptional.get();
            tipo.setNomeTipo(tipoDetails.getNomeTipo()); 
            return tipoRepository.save(tipo);
        }
        return null;
    }

    // Deleta um tipo pelo ID
    public void deleteTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}