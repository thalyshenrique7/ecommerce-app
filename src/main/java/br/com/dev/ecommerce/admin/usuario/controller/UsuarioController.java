package br.com.dev.ecommerce.admin.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.usuario.dto.UsuarioDTO;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;
import br.com.dev.ecommerce.admin.usuario.service.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO buscar(@PathVariable(value = "id") Long id) {

		return usuarioService.buscar(id);

	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Usuario usuario) {

		usuarioService.salvar(usuario);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable(value = "id") Long id) {

		//Usuario usuario = usuarioService.buscar(id);

		//usuarioService.excluir(usuario);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Usuario novoUsuario) {

		usuarioService.atualizar(id, novoUsuario);
	}
}
