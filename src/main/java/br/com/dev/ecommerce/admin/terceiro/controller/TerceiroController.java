package br.com.dev.ecommerce.admin.terceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;
import br.com.dev.ecommerce.admin.terceiro.service.TerceiroServiceImpl;

@RestController
@RequestMapping(value = "api/terceiro", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerceiroController {

	@Autowired
	private TerceiroServiceImpl terceiroService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Terceiro> buscar(@PathVariable(value = "id") Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.terceiroService.buscar(id));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Terceiro terceiro) {
		
		this.terceiroService.salvar(terceiro);
	}
}
