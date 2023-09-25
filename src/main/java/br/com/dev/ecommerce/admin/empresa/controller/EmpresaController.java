package br.com.dev.ecommerce.admin.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.empresa.service.EmpresaServiceImpl;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaServiceImpl empresaService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Empresa empresa) {

		this.empresaService.salvar(empresa);
	}
}
