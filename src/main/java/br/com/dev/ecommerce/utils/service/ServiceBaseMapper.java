package br.com.dev.ecommerce.utils.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Operator;

import br.com.dev.ecommerce.dto.AbstractDTO;
import br.com.dev.ecommerce.utils.EntityBaseRoot;

public interface ServiceBaseMapper<TEntity extends EntityBaseRoot, TDto extends AbstractDTO> extends ServiceBase<TEntity> {

	/**
	 * Mapeia a entidade para seu respectivo DTO
	 * 
	 * @param entity Entidade a ser mapeada
	 * @return DTO da entidade
	 */
	TDto toDTO(TEntity entity);

	/**
	 * Mapeia uma lista de entidades para uma lista de respectivos DTOs
	 * 
	 * @param entities Lista de entidades a serem mapeadas
	 * @return Lista de DTOs resultantes.
	 */
	List<TDto> toDTOs(List<TEntity> entities);

	TEntity toEntity(TDto dto);

	List<TEntity> toEntities(List<TDto> dtos);

	TDto findDtoById(Long id);

	List<TDto> findDtoByIds(final Collection<Long> ids);

	List<TDto> findAllDto();

	TDto findOneDto(Specification<TEntity> specification);

	Page<TDto> findAllDto(Pageable pageable);

	List<TDto> findAllDto(Specification<TEntity> specification);

	List<TDto> findAllDto(Specification<TEntity> specification, Sort sort);

	Page<TDto> findAllDto(Specification<TEntity> specification, Pageable pageable);

	List<TDto> findDtoByQuery(Operator queryOperator, String query);

	Page<TDto> findDtoByQuery(Operator queryOperator, String query, Pageable pageable);

	List<TEntity> saveDtos(List<TDto> dto) throws Exception;

	TEntity save(TDto dto) throws Exception;

	TEntity patch(TDto dto, Long id) throws Exception;

	Page<TDto> toPageDTO(Page<TEntity> page, Pageable pageable);
}
