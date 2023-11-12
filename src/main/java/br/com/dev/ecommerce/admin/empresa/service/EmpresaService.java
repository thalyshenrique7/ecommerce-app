package br.com.dev.ecommerce.admin.empresa.service;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;

public interface EmpresaService {
	
	public EmpresaDTO buscar(Long id) throws Exception;

	public void salvar(Empresa empresa) throws Exception;
}
