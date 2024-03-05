package br.com.dev.ecommerce.utils.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import br.com.dev.ecommerce.dto.AbstractDTO;
import br.com.dev.ecommerce.utils.EntityBaseRoot;
import br.com.dev.ecommerce.utils.repository.RepositoryBase;

public abstract class MapperBaseImpl<TEntity extends EntityBaseRoot> {

	private Class<TEntity> typeBase;
	
	@Autowired
	protected RepositoryBase<TEntity> repository;
	
	public MapperBaseImpl(Class<TEntity> clazz) {

		this.typeBase = clazz;
	}
	
	@ObjectFactory
	public TEntity resolve(AbstractDTO dto) {

		return dto != null ? resolve(dto.getId()) : null;
	}
	
	public TEntity map(Long id) {

		if (id == null)
			return null;

		TEntity entity = resolve(id);

		if (entity == null)
			return null;

		entity.setId(id);
		return entity;
	}

	public Collection<TEntity> mapCollection(Collection<Long> values) throws InstantiationException, IllegalAccessException {

		Collection<TEntity> entities = new ArrayList<>();

		for (Long value : values)
			entities.add(this.map(value));

		return entities;

	}

	public Long mapToLong(TEntity entity) {

		if (entity == null)
			return null;

		return ((EntityBaseRoot) entity).getId();
	}

	public Collection<Long> mapToLongList(List<TEntity> entities) {

		List<Long> ids = new ArrayList<>();

		if (CollectionUtils.isEmpty(entities))
			return ids;

		for (TEntity entity : entities)
			ids.add(this.mapToLong(entity));

		return ids;

	}

	private TEntity resolve(Long id) {

		TEntity entity = null;

		if (id != null)
			entity = (TEntity) this.repository.findById(id).orElse(entity);

		try {

			return entity != null ? entity : typeBase.newInstance();

		} catch (InstantiationException e) {

			return null;

		} catch (IllegalAccessException e) {

			return null;
		}
	}

}
