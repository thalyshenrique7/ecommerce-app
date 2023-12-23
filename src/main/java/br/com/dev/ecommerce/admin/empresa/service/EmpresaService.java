package br.com.dev.ecommerce.admin.empresa.service;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;

public interface EmpresaService {
	
	public EmpresaDTO buscar(Long id) throws Exception;

	public void salvar(EmpresaDTO empresaDTO) throws Exception;
}
