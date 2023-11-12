package br.com.dev.ecommerce.admin.terceiro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;

@Repository
public interface TerceiroRepository extends CrudRepository<Terceiro, Long> {

}
