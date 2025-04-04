package br.com.joalheriajoiasjoia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joalheriajoiasjoia.app.entities.Ornamentos;
import br.com.joalheriajoiasjoia.app.services.OrnamentosService;

@RestController
@RequestMapping("/ornamentos")
public class OrnamentosController {

    @Autowired
    private OrnamentosService ornamentosService;

    @GetMapping
    public List<Ornamentos> getAllOrnamentos() {
        return ornamentosService.getAllOrnamentos();
    }

    @GetMapping("/{id}")
    public Ornamentos getOrnamentosById(@PathVariable Long id) {
        return ornamentosService.getOrnamentoById(id);
    }

    @PostMapping
    public Ornamentos createOrnamentos(@RequestBody Ornamentos ornamentos) {
        return ornamentosService.saveOrnamento(ornamentos);
    }

    @PutMapping("/{id}")
    public Ornamentos updateOrnamentos(@PathVariable Long id, @RequestBody Ornamentos ornamentosDetails) {
        return ornamentosService.updateOrnamento(id, ornamentosDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrnamentos(@PathVariable Long id) {
        ornamentosService.deleteOrnamento(id);
    }
}