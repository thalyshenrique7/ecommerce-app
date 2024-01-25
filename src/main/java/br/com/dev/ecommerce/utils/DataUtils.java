package br.com.dev.ecommerce.utils;

import java.util.Calendar;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@MappedSuperclass
public class DataUtils {

	@Audited
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Audited
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAlteracao;

	public Calendar getDataCriacao() {

		if (dataCriacao == null)
			this.setDataCriacao(Calendar.getInstance());

		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataAlteracao() {

		if (dataAlteracao == null)
			this.setDataAlteracao(Calendar.getInstance());

		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
