package br.com.dev.ecommerce.admin.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.login.dto.LoginDTO;
import br.com.dev.ecommerce.admin.login.service.LoginServiceImpl;

@RestController
@RequestMapping(value = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void acessar(@RequestBody LoginDTO dto) {

		this.loginService.acessar(dto);
	}
}
