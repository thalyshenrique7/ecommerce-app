package br.com.dev.ecommerce.admin.entidade.enums;

public enum Status {

	INATIVO(0, "Inativo"), 
	ATIVO(1, "Ativo"), 
	EXCLUIDO(2, "Excluido");
	
	private int id;
	
	private String descricao;
	
	private Status(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
