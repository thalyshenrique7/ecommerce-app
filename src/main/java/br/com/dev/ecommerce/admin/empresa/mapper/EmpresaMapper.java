package br.com.dev.ecommerce.admin.empresa.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EmpresaMapper extends Empresa implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public EmpresaMapper() {

		super(Empresa.class);
	}

	public abstract EmpresaDTO toDTO(Empresa empresa);

	@Mappings({ @Mapping(target = "entidades", source = "entidades", qualifiedByName = "mapEntidades"), })
	public abstract Empresa toEntity(EmpresaDTO empresa);

	@Named(value = "mapEntidades")
	public List<Long> mapEntidades(List<Entidade> entidades) {

		return entidades.stream().map(Entidade::getId).collect(Collectors.toList());
	}

}
