package br.com.dev.ecommerce.admin.usuario.service;

import br.com.dev.ecommerce.admin.usuario.dto.UsuarioDTO;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;

public interface UsuarioService {

	UsuarioDTO buscar(Long id);

	void salvar(Usuario usuario);

	void excluir(Usuario usuario);

	void atualizar(Long id, Usuario novoUsuario);
}
