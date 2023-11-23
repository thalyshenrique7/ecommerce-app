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

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	public UsuarioDTO buscar(Long id) {

		Usuario usuario;

		try {

			usuario = this.usuarioRepository.findById(id).orElse(null);

		} catch (Exception e) {
			throw new RuntimeException("Usuário não foi encontrado no sistema.", e);
		}

		UsuarioDTO dto = this.usuarioMapper.toDTO(usuario);

		return dto;
	}

	@Override
	public void salvar(Usuario usuario) {

		if (usuario != null) {

			try {

				usuarioRepository.save(usuario);

			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro ao tentar salvar o usuário.", e);

			}
		}
	}

	@Override
	public void excluir(Long id) {

		if (id != null) {

			Usuario usuario = this.usuarioRepository.findById(id).orElse(null);

			try {

				usuarioRepository.delete(usuario);

			} catch (Exception e) {
				throw new RuntimeException("Usuário não foi encontrado no sistema.", e);
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
				throw new RuntimeException("Usuário não foi encontrado no sistema.", e);
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
