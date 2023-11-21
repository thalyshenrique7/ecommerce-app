package br.com.dev.ecommerce.admin.terceiro.service;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;

public interface TerceiroService {

	public Terceiro buscar(Long id);

	public void salvar(Terceiro terceiro);

	public void excluir(Long id);

	public void atualizar(Long id, Terceiro novoTerceiro);

}
