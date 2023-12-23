package br.com.dev.ecommerce.admin.entidade.mapper;

import java.io.Serializable;
import java.util.List;

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
		@Mapping(target = "statusDescricao", source = "status.descricao"),
	})
	public abstract EntidadeDTO toDTO(Entidade entidade);
	
	@Mappings({
		@Mapping(target = "statusDescricao", source = "status.descricao"),
	})
	public abstract List<EntidadeDTO> toDTOs(List<Entidade> dto);
	
	public abstract List<Entidade> toEntities(List<EntidadeDTO> dtos);

}
