package br.com.dev.ecommerce.admin.entidade.service;

import java.util.List;

import br.com.dev.ecommerce.admin.entidade.dto.EntidadeDTO;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;

public interface EntidadeService {

	public EntidadeDTO buscar(Long id);

	public void salvar(Entidade entidade);

	public void excluir(Long id);

	public List<EntidadeDTO> getEntidades();
	
	public List<Entidade> getEntidadeByIds(List<Long> ids);
}
