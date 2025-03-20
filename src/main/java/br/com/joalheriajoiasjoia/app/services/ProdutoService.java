package br.com.joalheriajoiasjoia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Produto;
import br.com.joalheriajoiasjoia.app.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Retorna todos os produtos
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // Retorna um produto pelo ID
    public Produto getProdutoById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    // Salva um novo produto
    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualiza um produto existente
    public Produto updateProduto(Long id, Produto produtoDetails) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNomeProduto(produtoDetails.getNomeProduto());
            produto.setCategoria(produtoDetails.getCategoria());
            produto.setTipo(produtoDetails.getTipo());
            produto.setMaterial(produtoDetails.getMaterial());
            produto.setPedras(produtoDetails.getPedras());
            return produtoRepository.save(produto);
        }
        return null;
    }

    // Deleta um produto pelo ID
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}