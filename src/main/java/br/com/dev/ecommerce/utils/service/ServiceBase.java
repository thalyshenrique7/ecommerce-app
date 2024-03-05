package br.com.dev.ecommerce.utils.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.engine.internal.JoinSequence.Selector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Operator;

import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.utils.EntityBaseRoot;

public interface ServiceBase<TEntity extends EntityBaseRoot> {

	/**
	 * Busca um objeto pelo seu id único de sistema.
	 * 
	 * @param id id único do objeto no sistema.
	 * @return Objeto associado ao id informado.
	 * @throws EntityNotFoundException Disparada quando não foi encontrado o objeto com o id informado.
	 */
	TEntity findById(Long id) throws NotFoundException;

	/**
	 * Busca os objetos associados aos ids informados.
	 * 
	 * @param ids Ids dos objetos buscados.
	 * @return Lista de objetos associados as ids informados.
	 */
	List<TEntity> findByIds(final Collection<Long> ids);

	/**
	 * Salva ou atualiza um objeto no contexto de persistência.
	 * 
	 * @param entity Objeto a ser salvo.
	 * @return Instância do objeto após ser salvo no contexto de persistência.
	 * @throws Exception
	 */
	TEntity save(TEntity entity) throws Exception;

	/**
	 * Salva ou atualiza uma lista de objetos no contexto de persistência.
	 * 
	 * @param entities Entidades a serem persistidas.
	 * @return Lista de entidades atualizadas após serem salvas.
	 * @throws Exception
	 */
	List<TEntity> save(List<TEntity> entities) throws Exception;

	/**
	 * Atualiza apenas as propriedades não nulas do objeto recebido no objeto persistido sobre o id informado.
	 * 
	 * @param changes Objeto com as mudanças a serem aplicadas.
	 * @param id Id do objeto no qual serão aplicadas as mudanç as.
	 * @return Entidade atualizada completa.
	 * @throws Exception Disparada quando uma validação não foi satisfeita no validateBeforeRemove, quando a entidade não foi
	 *             encontrada ou algum erro inesperado de persistência ocorra.
	 */
	TEntity patch(TEntity changes, Long id) throws Exception;

	/**
	 * Obtém todos os objetos persistidos na base.
	 * 
	 * @return Lista de objetos persistidos do tipo desejado.
	 */
	List<TEntity> findAll();

	/**
	 * Busca o objeto com base em uma especificação de consulta.
	 * 
	 * @param specification Specification para pesquisa do objeto.
	 * @return Objeto que corresponde a specification informada.
	 */
	TEntity findOne(Specification<TEntity> specification);

	/**
	 * Busca os objetos com paginação.
	 * 
	 * @param pageable Critérios de Paginação a serem aplicados.
	 * @return Página dos objetos de acordo com os critérios de paginação.
	 */
	Page<TEntity> findAll(Pageable pageable);

	/**
	 * Busca os objetos com base em uma especificação de consulta.
	 * 
	 * @param specification Specification para filtragem dos objetos.
	 * @return Lista dos objetos que correspondem a specification informada.
	 */
	List<TEntity> findAll(Specification<TEntity> specification);

	/**
	 * Busca os objetos com base em uma especificação de consulta e os retorna de forma ordenada.
	 * 
	 * @param specification Specification para filtragem dos objetos.
	 * @param sort Tipo da ordenação desejada.
	 * @return Lista dos objetos que correspondem a specification informada na ordem desejada.
	 */
	List<TEntity> findAll(Specification<TEntity> specification, Sort sort);

	/**
	 * Busca os objetos de forma paginada com base em uma especificação de consulta.
	 * 
	 * @param specification Specification para filtragem dos objetos.
	 * @param pageable Paginação a ser aplicada na consulta.
	 * @return Lista de objetos que correspondem a specification informada na página desejada.
	 */
	Page<TEntity> findAll(Specification<TEntity> specification, Pageable pageable);

	/**
	 * Busca objetos por meio de uma query dinâmica recebida via controller da API. <br>
	 * As queries se baseiam nos seletores JQuery. <br>
	 * <br>
	 * 
	 * <b>Exemplo:</b><br>
	 * nome^=teste (filtra os objetos com o atributo nome iniciando com teste)<br>
	 * nome=teste (filtra os objetos com nome exatamente igual a teste)<br>
	 * nascimento>1985-12-01T00:00:00 (filtra os objetos com data de nascimento > data informada)<br>
	 * <br>
	 * 
	 * Para saber quais são os seletores, veja o arquivo {@link Selector}
	 * 
	 * @param queryOperator Operador lógico para agrupamentos dos predicados gerados.
	 * @param query Query contendo a relação atributo x valor, separados por virgula.
	 * @return Objetos encontrados.
	 */
	List<TEntity> findByQuery(Operator queryOperator, String query);

	/**
	 * Busca objetos por meio de uma query dinâmica recebida via controller da API. <br>
	 * As queries se baseiam nos seletores JQuery. <br>
	 * <br>
	 * 
	 * <b>Exemplo:</b><br>
	 * nome^=teste (filtra os objetos com o atributo nome iniciando com teste)<br>
	 * nome=teste (filtra os objetos com nome exatamente igual a teste)<br>
	 * nascimento>1985-12-01T00:00:00 (filtra os objetos com data de nascimento > data informada)<br>
	 * <br>
	 * 
	 * Para saber quais são os seletores, veja o arquivo {@link Selector}
	 * 
	 * @param queryOperator Operador lógico para agrupamentos dos predicados gerados.
	 * @param query Query contendo a relação atributo x valor, separados por virgula.
	 * @param pageable Paginação que deve ser aplicada na consulta.
	 * @return Objetos encontrados.
	 */
	Page<TEntity> findByQuery(Operator queryOperator, String query, Pageable pageable);

	/**
	 * Remove um objeto da base.
	 * 
	 * Executa o método validateBeforeRemove, o qual pode ser sobrescrito para validações antes
	 * 
	 * @param entity Entidade a ser removida.
	 * @throws Exception Disparada quando uma validação não foi satisfeita no validateBeforeRemove, ou algum erro inesperado de
	 *             persistência ocorra.
	 */
	void remove(TEntity entity) throws Exception;

	/**
	 * Remove uma lista de objetos da base.
	 * 
	 * Executa o método validateBeforeRemove, o qual pode ser sobrescrito para validações antes
	 * 
	 * @param entity Lista de entidades a ser removida.
	 * @throws Exception Disparada quando uma validação não foi satisfeita no validateBeforeRemove, ou algum erro inesperado de
	 *             persistência ocorra.
	 */
	void remove(List<TEntity> entities) throws Exception;
}
