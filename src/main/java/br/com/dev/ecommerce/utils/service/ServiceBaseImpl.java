package br.com.dev.ecommerce.utils.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.utils.EntityBaseRoot;
import br.com.dev.ecommerce.utils.repository.CriteriaGenerator;
import br.com.dev.ecommerce.utils.repository.Operator;
import br.com.dev.ecommerce.utils.repository.RepositoryBase;
import br.com.dev.ecommerce.utils.repository.Selector;

@Transactional
public abstract class ServiceBaseImpl<TEntity extends EntityBaseRoot> implements ServiceBase<TEntity> {

	@Autowired
	protected RepositoryBase<TEntity> repositoryBase;

	private Class<TEntity> typeBase;

	public ServiceBaseImpl(Class<TEntity> typeBase) {

		this.typeBase = typeBase;
	}

	@Override
	public TEntity findById(Long id) throws NotFoundException {

		Assert.notNull(id, "id");

		TEntity entity = repositoryBase.findById(id).orElse(null);

		if (entity == null)
			throw new NotFoundException(typeBase, id.toString());

		return entity;
	}

	@Override
	public List<TEntity> findByIds(final Collection<Long> ids) {

		Assert.notEmpty(ids, "ids");

		Specification<TEntity> spec = new Specification<TEntity>() {

			@Override
			public Predicate toPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate predicate = root.get("id").in(ids);

				return predicate;
			}
		};

		List<TEntity> entity = repositoryBase.findAll(spec);

		return entity;
	}

	@Override
	public void remove(TEntity entity) throws Exception {

		validateBeforeRemove(entity);

		repositoryBase.delete(entity);
	}

	@Override
	public void remove(List<TEntity> entities) throws Exception {

		for (TEntity entity : entities) {
			validateBeforeRemove(entity);
			repositoryBase.delete(entity);
		}

	}

	@Override
	public TEntity save(TEntity entity) throws Exception {

		if (entity.getId() != null && entity.getId() > 0)
			validateBeforeUpdate(entity);
		else
			validateBeforeSave(entity);

		return repositoryBase.save(entity);
	}

	@Override
	public List<TEntity> save(List<TEntity> entities) throws Exception {

		List<TEntity> result = new ArrayList<TEntity>();

		if (entities == null)
			return result;

		for (TEntity entity : entities)
			result.add(save(entity));

		return result;
	}

	@Override
	public TEntity patch(TEntity changes, Long id) throws Exception {

//		TEntity entity = findById(id);
//
//		Assert.notNull(entity);
//
//		new BeanUtilsBean() {
//
//			@Override
//			public void copyProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {
//
//				if (value == null)
//					return;
//
//				super.copyProperty(bean, name, value);
//			}
//
//		}.copyProperties(entity, changes);
//
//		return save(entity);

		return null;
	}

	@Override
	public List<TEntity> findAll() {

		return repositoryBase.findAll();
	}

	@Override
	public Page<TEntity> findAll(Pageable pageable) {

		return repositoryBase.findAll(pageable);
	}

	@Override
	public TEntity findOne(Specification<TEntity> specification) {

		return repositoryBase.findOne(specification).orElse(null);
	}

	@Override
	public List<TEntity> findAll(Specification<TEntity> specification) {

		return repositoryBase.findAll(specification);
	}

	@Override
	public List<TEntity> findAll(Specification<TEntity> specification, Sort sort) {

		return repositoryBase.findAll(specification, sort);
	}

	@Override
	public Page<TEntity> findAll(Specification<TEntity> specification, Pageable pageable) {

		return repositoryBase.findAll(specification, pageable);
	}

	public List<TEntity> findByQuery(Operator queryOperator, String query) {

		List<TEntity> resultado = findAll(getDynamicSpec(queryOperator, query));

		return resultado;
	}

	public Page<TEntity> findByQuery(Operator queryOperator, String query, Pageable pageable) {

		Page<TEntity> resultado = findAll(getDynamicSpec(queryOperator, query), pageable);

		return resultado;
	}

	/**
	 * Sobrescreva o método e implemente qualquer regra de negócio que valide uma
	 * nova inserção de um registro na base.
	 * 
	 * @param entity Entidade que será salva.
	 * @throws VIllegalPersistentObject Quando a entidade não pode ser salva.
	 * @throws Exception
	 */
	protected void validateBeforeSave(TEntity entity) throws Exception {

	}

	/**
	 * Sobrescreva o método e implemente qualquer regra de negócio que valide uma
	 * atualização de um registro na base.
	 * 
	 * @param entity Entidade que será atualizada
	 * @throws VIllegalPersistentObject Quando a entidade não pode ser salva.
	 */
	protected void validateBeforeUpdate(TEntity entity) throws Exception {

	}

	/**
	 * Sobrescreva o método e implemente qualquer regra de negócio que valide uma
	 * remoção de um registro na base.
	 * 
	 * @param entity Entidade que será atualizada
	 * @throws VIllegalPersistentObject Quando a entidade não pode ser salva.
	 */
	protected void validateBeforeRemove(TEntity entity) throws Exception {

	}

	protected Specification<TEntity> getDynamicSpec(final Operator queryOperator, final String queryCriterios) {

		return new Specification<TEntity>() {

			@Override
			public Predicate toPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return adicionarQueryPredicate(queryOperator, queryCriterios, root, query, cb);
			}
		};
	}

	public Predicate adicionarQueryPredicate(final Operator queryOperator, final String queryCriterios,
			Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		final String criterios[] = queryCriterios.split(",");

		Predicate predicate = null;

		if (queryOperator.equals(Operator.AND))
			predicate = cb.conjunction();
		else
			predicate = cb.disjunction();

		for (String criterio : criterios) {

			for (Selector selector : Selector.values()) {

				if (criterio.contains(selector.getCode())) {

					String column = criterio.substring(0, criterio.indexOf(selector.getCode()));
					String value = criterio
							.substring(criterio.indexOf(selector.getCode()) + selector.getCode().length());

					predicate.getExpressions()
							.add(CriteriaGenerator.getPredicate(root, query, cb, column, value, selector));

					break;
				}
			}
		}

		return predicate;
	}
}
