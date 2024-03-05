package br.com.dev.ecommerce.utils.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Operator;

import br.com.dev.ecommerce.dto.AbstractDTO;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.utils.EntityBaseRoot;
import br.com.dev.ecommerce.utils.mapper.MapperBase;

@Transactional
public abstract class ServiceBaseMapperImpl<TEntity extends EntityBaseRoot, TDto extends AbstractDTO>
		extends ServiceBaseImpl<TEntity> implements ServiceBaseMapper<TEntity, TDto> {

	@Autowired
	protected MapperBase<TEntity, TDto> mapper;

	public ServiceBaseMapperImpl(Class<TEntity> typeBase) {

		super(typeBase);
	}

	@Override
	public TDto toDTO(TEntity entity) {

		return mapper.toDTO(entity);
	}

	@Override
	public List<TDto> toDTOs(List<TEntity> entities) {

		return mapper.toDTOs(entities);
	}

	@Override
	public TEntity toEntity(TDto dto) {

		return mapper.toEntity(dto);
	}

	@Override
	public List<TEntity> toEntities(List<TDto> dtos) {

		return mapper.toEntity(dtos);
	}

	@Override
	public TDto findDtoById(Long id) {

		try {
			return toDTO(findById(id));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TDto> findDtoByIds(Collection<Long> ids) {

		return toDTOs(findByIds(ids));
	}

	@Override
	public List<TDto> findAllDto() {

		return toDTOs(findAll());
	}

	@Override
	public TDto findOneDto(Specification<TEntity> specification) {

		return toDTO(findOne(specification));
	}

	@Override
	public Page<TDto> findAllDto(Pageable pageable) {

		Page<TEntity> page = findAll(pageable);
		Page<TDto> pageDto = this.mapper.toPageDTO(page, pageable);

		return pageDto;
	}

	@Override
	public List<TDto> findAllDto(Specification<TEntity> specification) {

		return toDTOs(findAll(specification));
	}

	@Override
	public List<TDto> findAllDto(Specification<TEntity> specification, Sort sort) {

		return toDTOs(findAll(specification, sort));
	}

	@Override
	public Page<TDto> findAllDto(Specification<TEntity> specification, Pageable pageable) {

		Page<TEntity> page = findAll(specification, pageable);
		Page<TDto> pageDto = this.mapper.toPageDTO(page, pageable);

		return pageDto;

	}

	@Override
	public List<TDto> findDtoByQuery(Operator queryOperator, String query) {

		return toDTOs(findByQuery(queryOperator, query));
	}

	@Override
	public Page<TDto> findDtoByQuery(Operator queryOperator, String query, Pageable pageable) {

		Page<TEntity> page = findByQuery(queryOperator, query, pageable);
		Page<TDto> pageDto = this.toPageDTO(page, pageable);

		return pageDto;

	}

	@Override
	public TEntity save(TDto dto) throws Exception {

		TEntity entity = this.mapper.toEntity(dto);

		if (dto.getId() == null || dto.getId() == 0L)
			validateBeforeSave(entity);
		else
			validateBeforeUpdate(entity);

		return this.repositoryBase.save(entity);
	}

	@Override
	public TEntity patch(TDto dto, Long id) throws Exception {

		TEntity entity = this.mapper.toEntity(dto);

		return super.patch(entity, id);
	}

	@Override
	public List<TEntity> saveDtos(List<TDto> dto) throws Exception {

		List<TEntity> entities = new ArrayList<TEntity>();
		for (TDto entity : dto) {
			entities.add(save(entity));
		}

		return entities;
	}

	@Override
	public Page<TDto> toPageDTO(Page<TEntity> page, Pageable pageable) {

		return this.mapper.toPageDTO(page, pageable);
	}
}
