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
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.getId();
			return usuario;
		}).orElse(null);
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

}
