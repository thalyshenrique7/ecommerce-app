package br.com.dev.ecommerce.admin.entidade.dto;

import br.com.dev.ecommerce.admin.endereco.model.Endereco;
import br.com.dev.ecommerce.dto.AbstractDTO;

public class EntidadeDTO extends AbstractDTO {

	public String nome;

	public Endereco endereco;

	public String statusDescricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getStatusDescricao() {
		return statusDescricao;
	}

	public void setStatusDescricao(String statusDescricao) {
		this.statusDescricao = statusDescricao;
	}

}
