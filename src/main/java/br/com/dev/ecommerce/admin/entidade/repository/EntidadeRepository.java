package br.com.dev.ecommerce.admin.entidade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.admin.entidade.model.Entidade;

@Repository
public interface EntidadeRepository extends CrudRepository<Entidade, Long> {

}
