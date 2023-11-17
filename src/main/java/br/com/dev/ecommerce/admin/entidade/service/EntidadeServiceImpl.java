package br.com.dev.ecommerce.admin.entidade.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.entidade.dto.EntidadeDTO;
import br.com.dev.ecommerce.admin.entidade.mapper.EntidadeMapper;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;
import br.com.dev.ecommerce.admin.entidade.repository.EntidadeRepository;

@Service
public class EntidadeServiceImpl implements EntidadeService {

	@Autowired
	private EntidadeRepository entidadeRepository;

	@Autowired
	private EntidadeMapper entidadeMapper;

	@Override
	public EntidadeDTO buscar(Long id) {

		Entidade entidade;

		try {

			entidade = this.entidadeRepository.findById(id).orElse(null);

		} catch (Exception e) {
			throw new RuntimeException("A entidade não foi encontrada no sistema.", e);
		}

		EntidadeDTO dto = this.entidadeMapper.toDTO(entidade);

		return dto;
	}

	@Override
	public void salvar(Entidade entidade) {

		if (entidade != null) {
			
			entidade.setDataCriacao(Calendar.getInstance());
			entidade.setDataAlteracao(Calendar.getInstance());

			try {

				this.entidadeRepository.save(entidade);

			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro ao tentar salvar a entidade.", e);
			}
		}
	}

	@Override
	public void excluir(Long id) {

		Entidade entidade;

		if (id != null) {

			entidade = this.entidadeRepository.findById(id).orElse(null);

			try {

				this.entidadeRepository.delete(entidade);

			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro ao tentar excluir a entidade.");
			}
		}
	}

}
