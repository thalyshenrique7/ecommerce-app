package br.com.dev.ecommerce.admin.terceiro.service;

import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDTO;
import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDetalheDTO;

public interface TerceiroService {

	public TerceiroDetalheDTO buscar(Long id);

	public void salvar(TerceiroDTO terceiroDTO);

	public void excluir(Long id);

	public void atualizar(Long id, TerceiroDTO novoTerceiroDTO);

}
