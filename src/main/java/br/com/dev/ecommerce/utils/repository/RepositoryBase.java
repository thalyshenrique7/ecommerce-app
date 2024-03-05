package br.com.dev.ecommerce.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.utils.EntityBaseRoot;

@Repository
public interface RepositoryBase<TEntity extends EntityBaseRoot> extends JpaRepository<TEntity, Long>, JpaSpecificationExecutor<TEntity> {

}
