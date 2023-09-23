package br.com.dev.ecommerce.estoque.exception;

import java.io.Serializable;

public class EstoqueException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public EstoqueException(String mensagem) {
		super(mensagem);
	}

}
