package br.com.dev.ecommerce.estoque.exception.exceptionHandler;

import java.util.Arrays;
import java.util.Calendar;

public class ListaErros {

	private java.util.List<String> erros;
	private Calendar data;

	public ListaErros(java.util.List<String> erros) {
		this.erros = erros;
	}

	public ListaErros(String mensagemErro, Calendar data) {
		this.erros = Arrays.asList(mensagemErro);
		this.data = data;
	}

	public java.util.List<String> getErros() {
		return erros;
	}

	public void setErros(java.util.List<String> erros) {
		this.erros = erros;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

}
