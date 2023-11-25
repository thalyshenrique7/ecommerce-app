package br.com.dev.ecommerce.admin.terceiro.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDTO;
import br.com.dev.ecommerce.admin.terceiro.dto.TerceiroDetalheDTO;
import br.com.dev.ecommerce.admin.terceiro.mapper.TerceiroMapper;
import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;
import br.com.dev.ecommerce.admin.terceiro.repository.TerceiroRepository;

@Service
public class TerceiroServiceImpl implements TerceiroService {

	@Autowired
	private TerceiroRepository terceiroRepository;

	@Autowired
	private TerceiroMapper terceiroMapper;

	@Override
	public TerceiroDetalheDTO buscar(Long id) {

		Terceiro terceiro = null;

		if (id != null) {

			try {

				terceiro = this.terceiroRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("O terceiro não foi encontrado no sistema.", e);
			}
		}

		TerceiroDetalheDTO dto = this.terceiroMapper.toDetalheDTO(terceiro);

		return dto;
	}

	@Override
	public void salvar(TerceiroDTO terceiroDTO) {

		Terceiro terceiro = null;

		if (terceiroDTO != null) {

			terceiro = this.terceiroMapper.toEntity(terceiroDTO);

			terceiro.setDataCriacao(Calendar.getInstance());
			terceiro.setDataAlteracao(Calendar.getInstance());
			
			try {

				this.terceiroRepository.save(terceiro);

			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro ao tentar salvar o terceiro.", e);
			}
		}
	}

	@Override
	public void excluir(Long id) {

		Terceiro terceiro;

		if (id != null) {

			try {

				terceiro = this.terceiroRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("O terceiro não foi encontrado no sistema.", e);
			}

			this.terceiroRepository.delete(terceiro);
		}
	}

	@Override
	public void atualizar(Long id, TerceiroDTO novoTerceiroDTO) {

		if (id != null) {

			Terceiro terceiro;

			try {

				terceiro = this.terceiroRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("O terceiro não foi encontrado no sistema.", e);
			}

			terceiro.setNome(novoTerceiroDTO.getNome());
			terceiro.setDataAlteracao(Calendar.getInstance());

			this.terceiroRepository.save(terceiro);
		}
	}

}
