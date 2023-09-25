package br.com.dev.ecommerce.admin.empresa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import br.com.dev.ecommerce.admin.endereco.model.Endereco;

/**
 * @author Thalys Henrique
 * 
 *         26/08/2023 07:05
 */

@Entity
@DynamicUpdate
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@Column
	private boolean matriz = true;

	public Empresa() {

	}

	public Empresa(Class<Empresa> empresa) {

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

	public boolean isMatriz() {
		return matriz;
	}

	public void setMatriz(boolean matriz) {
		this.matriz = matriz;
	}

}
