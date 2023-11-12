package br.com.dev.ecommerce.estoque.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.model.PedidoVenda;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PedidoVendaMapper extends PedidoVenda implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public PedidoVendaMapper() {

		super(PedidoVenda.class);
	}

	@Mappings({
		@Mapping(target = "terceiroId", source = "terceiro.id"),
		@Mapping(target = "terceiroNome", source = "terceiro.nome"),
	})
	public abstract PedidoVendaDTO toDTO(PedidoVenda pedidoVenda);

}
