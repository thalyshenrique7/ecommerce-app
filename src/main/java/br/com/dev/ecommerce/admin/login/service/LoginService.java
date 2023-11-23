package br.com.dev.ecommerce.admin.login.service;

import br.com.dev.ecommerce.admin.login.dto.LoginDTO;

public interface LoginService {

	public boolean acessar(LoginDTO dto);
}
