package br.com.dev.ecommerce.admin.terceiro.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDTO;
import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDetalheDTO;
import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class TerceiroMapper extends Terceiro implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public TerceiroMapper() {

		super(Terceiro.class);
	}

	public abstract TerceiroDTO toDTO(Terceiro terceiro);
	
	@Mappings({
		@Mapping(target = "dataCriacao", ignore = true),
		@Mapping(target = "dataAlteracao", ignore = true),
	})
	public abstract Terceiro toEntity(TerceiroDTO terceiroDTO);
	
	@Mappings({
		@Mapping(target = "categoriaDescricao", source = "categoria.descricao"),
	})
	public abstract TerceiroDetalheDTO toDetalheDTO(Terceiro terceiro);

}
