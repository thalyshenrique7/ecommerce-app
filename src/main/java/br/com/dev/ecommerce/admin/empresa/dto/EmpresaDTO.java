package br.com.dev.ecommerce.admin.empresa.dto;

import br.com.dev.ecommerce.admin.endereco.model.Endereco;
import br.com.dev.ecommerce.dto.AbstractDTO;

public class EmpresaDTO extends AbstractDTO {

	private String nome;

	private Endereco endereco;

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

}
