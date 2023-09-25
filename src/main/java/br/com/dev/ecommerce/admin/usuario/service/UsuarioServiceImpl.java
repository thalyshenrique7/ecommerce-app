package br.com.dev.ecommerce.admin.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.usuario.dto.UsuarioDTO;
import br.com.dev.ecommerce.admin.usuario.mapper.UsuarioMapper;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;
import br.com.dev.ecommerce.admin.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	public UsuarioDTO buscar(Long id) {

		Usuario usuario;

		try {

			usuario = this.usuarioRepository.findById(id).orElse(null);

		} catch (Exception e) {
			throw e;
		}

		UsuarioDTO dto = this.usuarioMapper.setInformacoesUsuario(usuario);

		return dto;
	}

	@Override
	public void salvar(Usuario usuario) {

		if (usuario != null) {

			try {

				usuarioRepository.save(usuario);

			} catch (Exception e) {
				throw e;

			}
		}
	}

	@Override
	public void excluir(Usuario usuario) {

		if (usuario != null) {

			try {

				usuarioRepository.delete(usuario);

			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public void atualizar(Long id, Usuario novoUsuario) {

		Usuario usuario;

		if (id != null) {

			try {

				usuario = this.usuarioRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw e;
			}

			/*
			 * alteração de cpf e rg não são permitidas.
			 */
			usuario.setNome(novoUsuario.getNome());
			usuario.setPermissao(novoUsuario.getPermissao());
			usuario.setAtivo(novoUsuario.isAtivo());

			usuarioRepository.save(usuario);

		}
	}
}
