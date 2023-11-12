package br.com.dev.ecommerce.admin.entidade.enums;

public enum Status {

	INATIVO(0L, "Inativo"), ATIVO(1L, "Ativo"), EXCLUIDO(2L, "Excluido");

	private Long id;

	private String descricao;

	private Status(Long id, String descricao) {
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
