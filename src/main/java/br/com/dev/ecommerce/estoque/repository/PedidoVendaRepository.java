package br.com.dev.ecommerce.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.estoque.model.PedidoVenda;

@Repository
public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {

}
