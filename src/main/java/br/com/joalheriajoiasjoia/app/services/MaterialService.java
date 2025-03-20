package br.com.joalheriajoiasjoia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Material;
import br.com.joalheriajoiasjoia.app.repositories.MaterialRepository;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    // Retorna todos os materiais
    public List<Material> getAllMateriais() {
        return materialRepository.findAll();
    }

    // Retorna um material pelo ID
    public Material getMaterialById(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        return material.orElse(null);
    }

    // Salva um novo material
    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    // Atualiza um material existente
    public Material updateMaterial(Long id, Material materialDetails) {
        Optional<Material> materialOptional = materialRepository.findById(id);
        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            material.setNomeMaterial(materialDetails.getNomeMaterial());
            return materialRepository.save(material);
        }
        return null;
    }

    // Deleta um material pelo ID
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}