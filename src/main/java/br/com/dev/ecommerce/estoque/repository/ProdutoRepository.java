package br.com.dev.ecommerce.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryCustom {

}
