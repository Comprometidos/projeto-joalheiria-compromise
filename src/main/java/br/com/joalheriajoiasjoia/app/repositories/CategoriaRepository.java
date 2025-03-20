package br.com.joalheriajoiasjoia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joalheriajoiasjoia.app.entities.CategoriaProduto;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaProduto, Long> {
}