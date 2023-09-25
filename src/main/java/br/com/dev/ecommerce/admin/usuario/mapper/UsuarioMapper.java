package br.com.dev.ecommerce.admin.usuario.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.usuario.dto.UsuarioDTO;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UsuarioMapper extends Usuario implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public UsuarioMapper() {

		super(Usuario.class);
	}
	
	@Mappings({
		@Mapping(target = "nome", source = "nome"),
		@Mapping(target = "cpf", source = "cpf"),
		@Mapping(target = "rg", source = "rg"),
		@Mapping(target = "permissao", source = "usuario.permissao.tipo"),
		@Mapping(target = "ativo", source = "ativo"),
	})
	public abstract UsuarioDTO setInformacoesUsuario(Usuario usuario);
}
