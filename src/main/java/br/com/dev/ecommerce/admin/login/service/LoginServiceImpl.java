package br.com.dev.ecommerce.admin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.login.dto.LoginDTO;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;
import br.com.dev.ecommerce.admin.usuario.repository.UsuarioRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean acessar(LoginDTO dto) {

		Usuario usuario = this.usuarioRepository.findByEmail(dto.getEmail());

		if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {

			usuario.setLogado(true);

			return true;
		}

		return false;
	}

}
