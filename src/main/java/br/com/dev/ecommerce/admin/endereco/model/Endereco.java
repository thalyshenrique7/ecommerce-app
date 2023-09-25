package br.com.dev.ecommerce.admin.endereco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicUpdate;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.endereco.enums.Estado;

/**
 * @author Thalys Henrique
 * 
 *         26/08/2023 08:46
 */

@Entity
@DynamicUpdate
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(length = 30)
	private String rua;

	@Column
	private Long numero;

	@NotEmpty
	@Column(length = 30)
	private String cidade;

	@Enumerated(EnumType.STRING)
	private Estado estado;

	@NotEmpty
	@Column(length = 15)
	private String pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
