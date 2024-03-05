package br.com.dev.ecommerce.admin.empresa.service;

import java.util.List;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.utils.service.ServiceBase;

public interface EmpresaService extends ServiceBase<Empresa> {

	public List<EmpresaDTO> buscarEmpresas();

	public EmpresaDTO buscar(Long id) throws Exception;

	public void salvar(EmpresaDTO empresaDTO) throws Exception;
}
