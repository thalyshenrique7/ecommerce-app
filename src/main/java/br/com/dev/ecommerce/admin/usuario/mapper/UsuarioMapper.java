package br.com.dev.ecommerce.admin.usuario.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.admin.usuario.dto.UsuarioDTO;
import br.com.dev.ecommerce.admin.usuario.model.Usuario;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UsuarioMapper extends Usuario implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public UsuarioMapper() {

		super(Usuario.class);
	}
	
	public abstract UsuarioDTO setInformacoesUsuario(Usuario usuario);
}
