package br.com.dev.ecommerce.admin.terceiro.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;
import br.com.dev.ecommerce.admin.terceiro.repository.TerceiroRepository;

@Service
public class TerceiroServiceImpl implements TerceiroService {

	@Autowired
	private TerceiroRepository terceiroRepository;

	@Override
	public Terceiro buscar(Long id) {

		Terceiro terceiro = null;

		if (id != null) {

			try {

				terceiro = this.terceiroRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("O terceiro não foi encontrado no sistema.", e);
			}
		}

		return terceiro;
	}

	@Override
	public void salvar(Terceiro terceiro) {

		if (terceiro != null) {
			
			terceiro.setDataCriacao(Calendar.getInstance());
			terceiro.setDataAlteracao(Calendar.getInstance());

			try {

				this.terceiroRepository.save(terceiro);

			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro ao tentar salvar o terceiro.", e);
			}
		}
	}

}
