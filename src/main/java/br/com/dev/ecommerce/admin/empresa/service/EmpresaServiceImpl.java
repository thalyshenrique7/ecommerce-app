package br.com.dev.ecommerce.admin.empresa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.empresa.dto.EmpresaDTO;
import br.com.dev.ecommerce.admin.empresa.mapper.EmpresaMapper;
import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.empresa.repository.EmpresaRepository;
import br.com.dev.ecommerce.admin.entidade.model.Entidade;
import br.com.dev.ecommerce.admin.entidade.repository.EntidadeRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaMapper empresaMapper;

	@Autowired
	private EntidadeRepository entidadeRepository;

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
	public void salvar(EmpresaDTO empresaDTO) throws Exception {

		Empresa empresa = null;

		if (empresaDTO != null) {

			empresaDTO.setDataCriacao(Calendar.getInstance());
			empresaDTO.setDataAlteracao(Calendar.getInstance());

			List<Entidade> entidades = this.entidadeRepository.findAll();

			for (Entidade entidade : entidades) {

				List<Long> entidadeIds = new ArrayList<Long>();

				entidadeIds.add(entidade.getId());

				empresaDTO.setEntidades(entidadeIds);
			}

			empresa = this.empresaMapper.toEntity(empresaDTO);

			try {

				this.empresaRepository.save(empresa);

			} catch (Exception e) {
				throw new Exception("Ocorreu um erro ao tentar salvar a empresa.", e);
			}
		}
	}
	
}
