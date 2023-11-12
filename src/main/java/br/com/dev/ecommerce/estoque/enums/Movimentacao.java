package br.com.dev.ecommerce.estoque.enums;

public enum Movimentacao {

	SALDO_INICIAL(0L, "Saldo Inicial"), ENTRADA(1L, "Entrada"), SAIDA(2L, "Saida"), TRANSFERENCIA(3L, "Transferencia");

	private Long id;

	private String tipo;

	private Movimentacao(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
