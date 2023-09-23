package br.com.dev.ecommerce.estoque.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.model.Produto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProdutoMapper extends Produto implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public ProdutoMapper() {

		super(Produto.class);
	}
	
	@Mappings({
		@Mapping(target = "nome", source = "nome"),
		@Mapping(target = "ncm", source = "ncm"),
		@Mapping(target = "codigoBarras", source = "codigoBarras"),
	})
	public abstract ProdutoDTO setInformacoesProduto(Produto produto);
}
