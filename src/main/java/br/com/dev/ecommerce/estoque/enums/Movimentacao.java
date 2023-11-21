package br.com.dev.ecommerce.estoque.enums;

public enum Movimentacao {

	SALDO_INICIAL(0L, "Saldo Inicial"), ENTRADA(1L, "Entrada"), SAIDA(2L, "Saida"), TRANSFERENCIA(3L, "Transferencia");

	private Long id;

	private String descricao;

	private Movimentacao(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
