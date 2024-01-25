package br.com.dev.ecommerce.admin.empresa.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dev.ecommerce.admin.endereco.dto.EnderecoDTO;
import br.com.dev.ecommerce.dto.AbstractDTO;

public class EmpresaDTO extends AbstractDTO {

	private String nome;
	private String cnpj;

	private EnderecoDTO endereco;

	private List<Long> entidades;

	private Calendar dataCriacao;
	private Calendar dataAlteracao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public List<Long> getEntidades() {

		if (entidades == null)
			entidades = new ArrayList<Long>();

		return entidades;
	}

	public void setEntidades(List<Long> entidades) {
		this.entidades = entidades;
	}

}
