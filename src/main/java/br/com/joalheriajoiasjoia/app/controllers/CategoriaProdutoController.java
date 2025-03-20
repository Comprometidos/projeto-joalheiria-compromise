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

import br.com.joalheriajoiasjoia.app.entities.CategoriaProduto;
import br.com.joalheriajoiasjoia.app.services.CategoriaService;

@RestController
@RequestMapping("/categorias-produto")
public class CategoriaProdutoController {

    @Autowired
    private CategoriaService categoriaProdutoService;

    @GetMapping
    public List<CategoriaProduto> getAllCategorias() {
        return categoriaProdutoService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaProduto getCategoriaById(@PathVariable Long id) {
        return categoriaProdutoService.getCategoriaById(id);
    }

    @PostMapping
    public CategoriaProduto createCategoria(@RequestBody CategoriaProduto categoriaProduto) {
        return categoriaProdutoService.saveCategoria(categoriaProduto);
    }

    @PutMapping("/{id}")
    public CategoriaProduto updateCategoria(@PathVariable Long id, @RequestBody CategoriaProduto categoriaDetails) {
        return categoriaProdutoService.updateCategoria(id, categoriaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaProdutoService.deleteCategoria(id);
    }
}