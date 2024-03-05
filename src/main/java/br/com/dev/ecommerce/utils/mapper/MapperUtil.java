package br.com.dev.ecommerce.utils.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import br.com.dev.ecommerce.utils.EntityBaseRoot;

public class MapperUtil {

	public static Collection<Long> toListIds(Collection<? extends EntityBaseRoot> entities) {

		Set<Long> ids = new HashSet<Long>();

		for (EntityBaseRoot entity : entities)
			ids.add(entity.getId());

		return ids;
	}
	
	public static <T extends EntityBaseRoot> T toEntity(Long id, Class<T> clazz) {
		
		if (id == null) {
			return null;
		}
		
		T obj = null;
		
		try {
			
			obj = clazz.newInstance();
			obj.setId(id);
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	public static <T extends EntityBaseRoot> Set<T> toEntityList(Collection<Long> ids, Class<T> clazz) {

		Set<T> entities = new HashSet<>();

		if (CollectionUtils.isEmpty(ids))
			return null;

		try {

			for (Long id : ids) {

				T obj = clazz.newInstance();
				obj.setId(id);

				entities.add(obj);

			}

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return entities;

	}

	public static Long toId(EntityBaseRoot entity) {

		if (entity == null)
			return null;

		return entity.getId();

	}

}
