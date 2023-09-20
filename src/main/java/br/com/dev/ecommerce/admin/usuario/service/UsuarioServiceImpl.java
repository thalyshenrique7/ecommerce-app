package br.com.dev.ecommerce.admin.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.usuario.model.Usuario;
import br.com.dev.ecommerce.admin.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void salvar(Usuario usuario) {

		try {

			if (usuario != null) {

				usuarioRepository.save(usuario);

			}

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void excluir(Usuario usuario) {

		try {

			if (usuario != null) {

				usuarioRepository.delete(usuario);

			}

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void atualizar(Long id, Usuario novoUsuario) {

		if (id != null) {

			try {

				/*
				 * alteração de cpf e rg não são permitidas.
				 */
				Usuario usuario = this.buscar(id);

				usuario.setNome(novoUsuario.getNome());
				usuario.setPermissao(novoUsuario.getPermissao());

				usuarioRepository.save(usuario);

			} catch (Exception e) {
				throw e;
			}

		}

	}

}
