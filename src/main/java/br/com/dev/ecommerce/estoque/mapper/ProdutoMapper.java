package br.com.dev.ecommerce.estoque.mapper;

import java.io.Serializable;
import java.util.List;

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
		@Mapping(target = "movimentacaoDescricao", source = "movimentacao.descricao"),
	})
	public abstract ProdutoDTO toDTO(Produto produto);
	
	@Mappings({
		@Mapping(target = "movimentacaoDescricao", source = "movimentacao.descricao"),
	})
	public abstract List<ProdutoDTO> toDTOs(List<Produto> produtos);
	
	public abstract Produto toEntity(ProdutoDTO dto);
}
