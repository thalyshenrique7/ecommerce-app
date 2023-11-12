package br.com.dev.ecommerce.admin.entidade.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.entidade.dto.EntidadeDTO;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EntidadeMapper extends Entidade implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;
	
	public EntidadeMapper() {
		
		super(Entidade.class);
	}
	
	@Mappings({
		@Mapping(target = "empresaId", source = "empresa.id"),
		@Mapping(target = "empresaNome", source = "empresa.nome"),
		@Mapping(target = "statusDescricao", source = "status.descricao"),
	})
	public abstract EntidadeDTO toDTO(Entidade entidade);

}
