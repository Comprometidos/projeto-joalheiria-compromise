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

import br.com.joalheriajoiasjoia.app.entities.TipoProduto;
import br.com.joalheriajoiasjoia.app.services.TipoProdutoService;

@RestController
@RequestMapping("/tipos-produto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @GetMapping
    public List<TipoProduto> getAllTipos() {
        return tipoProdutoService.getAllTipos();
    }

    @GetMapping("/{id}")
    public TipoProduto getTipoById(@PathVariable Long id) {
        return tipoProdutoService.getTipoById(id);
    }

    @PostMapping
    public TipoProduto createTipo(@RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.saveTipo(tipoProduto);
    }

    @PutMapping("/{id}")
    public TipoProduto updateTipo(@PathVariable Long id, @RequestBody TipoProduto tipoDetails) {
        return tipoProdutoService.updateTipo(id, tipoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTipo(@PathVariable Long id) {
        tipoProdutoService.deleteTipo(id);
    }
}