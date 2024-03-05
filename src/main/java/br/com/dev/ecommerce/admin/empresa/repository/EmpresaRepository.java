package br.com.dev.ecommerce.admin.empresa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.utils.repository.RepositoryBase;

@Repository
public interface EmpresaRepository extends RepositoryBase<Empresa> {

	List<Empresa> findByDeletadoFalse();
}
