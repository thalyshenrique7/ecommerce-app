package br.com.dev.ecommerce.utils.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dev.ecommerce.dto.AbstractDTO;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.utils.EntityBaseRoot;
import br.com.dev.ecommerce.utils.service.ServiceBaseMapper;

public class ControllerBase<TEntity extends EntityBaseRoot, TDto extends AbstractDTO, TService extends ServiceBaseMapper<TEntity, TDto>> {

	final static Logger LOG = LoggerFactory.getLogger(ControllerBase.class);
	
	@Autowired
	protected TService service;
	
    /**
     * Busca paginada de todos os objetos do BD.
     * 
     * @param pageable Critérios de paginação e ordenação.
     * @return Página de objetos
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TDto>> findAll(Pageable pageable, HttpServletRequest req) {
        
    		return new ResponseEntity<>(service.findAllDto(pageable), HttpStatus.OK);
    } 
    
    /**
     * Busca de um objeto pelo seu Id.
     * 
     * @param id Id do objeto Buscado.
     * 
     * @return Objeto que faz match com o Id informado.
     * 
     * @throws VNotFoundException Disparada quando o objeto não é encontrado.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TDto> findById(@PathVariable("id") Long id, HttpServletRequest req) throws NotFoundException {
    	
        return new ResponseEntity<>(service.findDtoById(id), HttpStatus.OK);
    }

	/**
     * Busca de um objeto por uma lista de IDs.
     * 
     * @param id Ids do objetos Buscados.
     * 
     * @return Objeto que faz match com os Ids informados.
     * 
     */
    @RequestMapping(value = "/list/{id[]}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TDto>> findByIds(@PathVariable("id[]") List<Long> ids, HttpServletRequest req) {
    
        return new ResponseEntity<>(service.findDtoByIds(ids), HttpStatus.OK);
    }
    
//    @RequestMapping(value = "query/and/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<TDto>> findByQueryAnd(@PathVariable("query") String query, Pageable pageable, HttpServletRequest req) {
//     
//    		return new ResponseEntity<>(service.findDtoByQuery(Operator.AND, query, pageable), HttpStatus.OK);
//    } 
//    
//    @RequestMapping(value = "query/or/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<TDto>> findByQueryOr(@PathVariable("query") String query, Pageable pageable, HttpServletRequest req) {
//        
//    		return new ResponseEntity<>(service.findDtoByQuery(Operator.OR, query, pageable), HttpStatus.OK);
//    } 
}
