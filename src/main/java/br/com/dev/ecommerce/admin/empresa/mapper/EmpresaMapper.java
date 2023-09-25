package br.com.dev.ecommerce.admin.empresa.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EmpresaMapper extends Empresa implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public EmpresaMapper() {
		
		super(Empresa.class);
	}
	
	@Mappings({
		@Mapping(target = "nome", source = "nome"),
		@Mapping(target = "endereco", source = "endereco"),
	})
	public abstract EmpresaDTO setInformacoesEmpresa(Empresa empresa);
}
