package br.com.dev.ecommerce.estoque.enums;

public enum Movimentacao {

	SALDO_INICIAL(0, "Saldo Inicial"),
	ENTRADA(1, "Entrada"),
	SAIDA(2, "Saida"),
	TRANSFERENCIA(3, "Transferencia");
	
	private int id;

	private String tipo;

	private Movimentacao(int id, String tipo) {
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
