package br.com.dev.ecommerce.admin.usuario.service;

import br.com.dev.ecommerce.admin.usuario.model.Usuario;

public interface UsuarioService {

	Usuario buscar(Long id);
	
	void salvar(Usuario usuario);
	
	void excluir(Usuario usuario);
}
