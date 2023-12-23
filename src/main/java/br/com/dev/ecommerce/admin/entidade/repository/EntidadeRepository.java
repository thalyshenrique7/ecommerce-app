package br.com.dev.ecommerce.admin.entidade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.ecommerce.admin.entidade.model.Entidade;

public interface EntidadeRepository extends CrudRepository<Entidade, Long> {

	List<Entidade> findAll();

	List<Entidade> findAllByIds(List<Long> ids);

}
