package br.com.dev.ecommerce.admin.empresa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.endereco.mapper.EnderecoMapper;
import br.com.dev.ecommerce.admin.entidade.mapper.EntidadeMapper;
import br.com.dev.ecommerce.utils.mapper.MapperBase;
import br.com.dev.ecommerce.utils.mapper.MapperBaseImpl;
import br.com.dev.ecommerce.utils.mapper.MapperUtil;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = MapperUtil.class, uses = { EnderecoMapper.class, EntidadeMapper.class })
public abstract class EmpresaMapper extends MapperBaseImpl<Empresa> implements MapperBase<Empresa, EmpresaDTO>{
	
	public EmpresaMapper() {

		super(Empresa.class);
	}

	public abstract EmpresaDTO toDTO(Empresa empresa);

	public abstract Empresa toEntity(EmpresaDTO empresa);

	public abstract List<EmpresaDTO> toDTOs(List<Empresa> entities);

}
