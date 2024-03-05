package br.com.dev.ecommerce.admin.entidade.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.entidade.dto.EntidadeDTO;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;
import br.com.dev.ecommerce.utils.mapper.MapperBase;
import br.com.dev.ecommerce.utils.mapper.MapperBaseImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EntidadeMapper extends MapperBaseImpl<Entidade> implements MapperBase<Entidade, EntidadeDTO> {

	public EntidadeMapper() {

		super(Entidade.class);
	}

	@Mappings({ @Mapping(target = "statusDescricao", source = "status.descricao"), })
	public abstract EntidadeDTO toDTO(Entidade entidade);

	@Mappings({ @Mapping(target = "statusDescricao", source = "status.descricao"), })
	public abstract List<EntidadeDTO> toDTOs(List<Entidade> dto);

	public abstract List<Entidade> toEntities(List<EntidadeDTO> dtos);

}
