package br.com.dev.ecommerce.admin.usuario.enums;

public enum Permissao {

	CLIENTE(1, "Cliente"), 
	VENDEDOR(2, "Vendedor"), 
	GERENTE(3, "Gerente"), 
	CAIXA(4, "Caixa");

	private int id;

	private String tipo;

	private Permissao(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
