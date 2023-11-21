package br.com.dev.ecommerce.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.service.ProdutoServiceImpl;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoServiceImpl produtoService;

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Produto buscar(@PathVariable(value = "id") Long id) {

		return this.produtoService.buscar(id);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Produto produto) {

		this.produtoService.salvar(produto);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable(value = "id") Long id) {

		Produto produto = this.produtoService.buscar(id);

		this.produtoService.excluir(produto);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {

		this.produtoService.atualizar(id, produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> getProdutos() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutos());
	}
}
