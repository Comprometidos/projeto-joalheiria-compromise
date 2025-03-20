package br.com.joalheriajoiasjoia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Ornamentos;
import br.com.joalheriajoiasjoia.app.repositories.OrnamentosRepository;

@Service
public class OrnamentosService {

    @Autowired
    private OrnamentosRepository ornamentosRepository;

    // Retorna todas os ornamentos
    public List<Ornamentos> getAllOrnamentos() {
        return ornamentosRepository.findAll();
    }

    // Retorna um ornamento pelo ID
    public Ornamentos getOrnamentoById(Long id) {
        Optional<Ornamentos> pedra = ornamentosRepository.findById(id);
        return pedra.orElse(null);
    }

    // Salva uma novo ornamento
    public Ornamentos saveOrnamento(Ornamentos pedra) {
        return ornamentosRepository.save(pedra);
    }

    // Atualiza um ornamento existente
    public Ornamentos updateOrnamento(Long id, Ornamentos pedraDetails) {
        Optional<Ornamentos> pedraOptional = ornamentosRepository.findById(id);
        if (pedraOptional.isPresent()) {
        	Ornamentos pedra = pedraOptional.get();
            pedra.setNomeOrnamento(pedraDetails.getNomeOrnamento());
            return ornamentosRepository.save(pedra);
        }
        return null;
    }

    // Deleta um ornamento pelo ID
    public void deleteOrnamento(Long id) {
    	ornamentosRepository.deleteById(id);
    }
}