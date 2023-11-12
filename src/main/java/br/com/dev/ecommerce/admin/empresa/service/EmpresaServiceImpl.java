package br.com.dev.ecommerce.admin.empresa.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.mapper.EmpresaMapper;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.empresa.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaMapper empresaMapper;

	@Override
	public EmpresaDTO buscar(Long id) throws Exception {

		Empresa empresaId;

		EmpresaDTO dto;

		try {

			empresaId = this.empresaRepository.findById(id).orElse(null);

			dto = this.empresaMapper.toDTO(empresaId);
		} catch (Exception e) {
			throw new Exception("A empresa não foi encontrada no sistema.", e);
		}

		return dto;
	}

	@Override
	public void salvar(Empresa empresa) throws Exception {

		if (empresa != null) {
			
			empresa.setDataCriacao(Calendar.getInstance());
			empresa.setDataAlteracao(Calendar.getInstance());

			try {

				this.empresaRepository.save(empresa);

			} catch (Exception e) {
				throw new Exception("Ocorreu um erro ao tentar salvar a empresa.", e);
			}
		}
	}
}
