package br.com.dev.ecommerce.admin.endereco.dto;

import br.com.dev.ecommerce.dto.AbstractDTO;

public class EnderecoDTO extends AbstractDTO {

	private Long numero;

	private String rua;
	private String cidade;
	private String estado;
	private String pais;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
