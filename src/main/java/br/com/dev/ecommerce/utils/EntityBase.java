package br.com.dev.ecommerce.utils;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

/*
 * Classe base para entidades que usam data criação, data alteração e identificador
 */
@MappedSuperclass
public abstract class EntityBase extends EntityBaseRoot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Audited
	protected Calendar dataCriacao;

	@Audited
	protected Calendar dataAlteracao;

	@PrePersist
	protected void onCreate() {

		if (dataCriacao == null)
			dataCriacao = Calendar.getInstance();

		dataAlteracao = Calendar.getInstance();
	}

	@PreUpdate
	protected void onUpdate() {

		dataAlteracao = Calendar.getInstance();

		if (dataCriacao == null)
			dataCriacao = dataAlteracao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataCriacao", nullable = false)
	public Calendar getDataCriacao() {

		return dataCriacao;
	}

	protected void setDataCriacao(Calendar dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataAlteracao", nullable = false)
	public Calendar getDataAlteracao() {

		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar DataAlteracao) {

		this.dataAlteracao = DataAlteracao;
	}
}
