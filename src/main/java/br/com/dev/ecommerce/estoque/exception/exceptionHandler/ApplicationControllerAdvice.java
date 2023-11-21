package br.com.dev.ecommerce.estoque.exception.exceptionHandler;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ListaErros handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> erros = e.getBindingResult().getAllErrors()
				.stream()
				.map(erro -> erro.getDefaultMessage())
				.collect(Collectors.toList());
		
		return new ListaErros(erros);
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ListaErros handleNotFoundException(NotFoundException e) {
		String erro = e.getMessage();
		Calendar data = Calendar.getInstance();
		
		return new ListaErros(erro, data);
	}
	
	@ExceptionHandler(EstoqueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ListaErros handleEstoqueException(EstoqueException e) {
		String erro = e.getMessage();
		Calendar data = Calendar.getInstance();
		
		return new ListaErros(erro, data);
	}
}
