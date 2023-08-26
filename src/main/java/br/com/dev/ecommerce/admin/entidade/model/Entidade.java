package br.com.dev.ecommerce.admin.entidade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.endereco.model.Endereco;
import br.com.dev.ecommerce.admin.entidade.enums.Status;

/**
 * @author Thalys Henrique
 * 
 *         26/08/2023 08:17
 */

@Entity
@DynamicUpdate
@Table(name = "entidade")
public class Entidade implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String nome;

	@OneToOne
	private Endereco endereco;

	@ManyToOne
	private Empresa empresa;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
}
