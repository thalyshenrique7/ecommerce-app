package br.com.dev.ecommerce.admin.endereco.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.endereco.dto.EnderecoDTO;
import br.com.dev.ecommerce.admin.endereco.model.Endereco;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EnderecoMapper extends Endereco implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public EnderecoMapper() {

		super(Endereco.class);
	}

	@Mapping(target = "estado.descricao", source = "estado")
	public abstract Endereco toEntity(EnderecoDTO dto);

}
