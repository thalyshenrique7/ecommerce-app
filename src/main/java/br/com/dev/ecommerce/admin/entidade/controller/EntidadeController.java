package br.com.dev.ecommerce.admin.entidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.admin.entidade.dto.EntidadeDTO;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;
import br.com.dev.ecommerce.admin.entidade.service.EntidadeServiceImpl;

@RestController
@RequestMapping(value = "api/entidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntidadeController {

	@Autowired
	private EntidadeServiceImpl entidadeService;

	@GetMapping(value = "{id}")
	public ResponseEntity<EntidadeDTO> buscar(@PathVariable(value = "id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(this.entidadeService.buscar(id));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Entidade entidade) {

		this.entidadeService.salvar(entidade);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable(value = "id") Long id) {
		
		this.entidadeService.excluir(id);
	}
	
	@GetMapping
	public ResponseEntity<List<EntidadeDTO>> getEntidades() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.entidadeService.getEntidades());
	}

}
