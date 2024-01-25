package br.com.dev.ecommerce.admin.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	List<Empresa> findByDeletadoFalse();
}
