package br.com.dev.ecommerce.admin.terceiro;

public enum Categoria {

	CLIENTE(1L, "Cliente"), 
	VENDEDOR(2L, "Vendedor"), 
	FORNECEDOR(3L, "Fornecedor");

	private Long id;

	private String descricao;

	private Categoria(Long id, String descricao) {
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
