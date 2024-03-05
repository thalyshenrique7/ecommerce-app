package br.com.dev.ecommerce.admin.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.service.EmpresaService;

@RestController
@RequestMapping(value = "/api/empresa", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@GetMapping(value = "{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public EmpresaDTO buscar(@PathVariable(value = "id") Long id) throws Exception {

		return this.service.buscar(id);
	}

	@PostMapping(value = "/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody EmpresaDTO empresaDTO) throws Exception {

		this.service.salvar(empresaDTO);
	}
}
