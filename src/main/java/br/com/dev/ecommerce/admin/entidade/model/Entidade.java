package br.com.dev.ecommerce.admin.entidade.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import br.com.dev.ecommerce.admin.endereco.model.Endereco;
import br.com.dev.ecommerce.admin.entidade.enums.Status;
import br.com.dev.ecommerce.utils.EntityBase;

/**
 * @author Thalys Henrique
 * 
 *         26/08/2023 08:17
 */

@Entity
@DynamicUpdate
@Table(name = "entidade")
public class Entidade extends EntityBase implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	public Entidade() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
