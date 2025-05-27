package br.com.joalheriajoiasjoia.app.repositories;

import br.com.joalheriajoiasjoia.app.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}