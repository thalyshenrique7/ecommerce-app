package br.com.dev.ecommerce.utils.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import br.com.dev.ecommerce.dto.AbstractDTO;
import br.com.dev.ecommerce.utils.EntityBaseRoot;

public interface MapperBase<TEntity extends EntityBaseRoot, TDto extends AbstractDTO> {

	public TDto toDTO(TEntity entity);

	public List<TDto> toDTOs(List<TEntity> entities);

	public TEntity toEntity(TDto dto);

	public List<TEntity> toEntity(List<TDto> dto);

	default Page<TDto> toPageDTO(Page<TEntity> page, Pageable pageable) {

		Assert.notNull(page, "Page não pode ser nulo.");
		Assert.notNull(pageable, "Pageable não pode ser nulo.");

		Page<TDto> pageDto = new PageImpl<TDto>(toDTOs(page.getContent()), pageable, page.getTotalElements());
		return pageDto;

	}
}
