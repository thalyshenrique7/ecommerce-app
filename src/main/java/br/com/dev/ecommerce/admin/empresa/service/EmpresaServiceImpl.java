package br.com.dev.ecommerce.admin.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.empresa.model.Empresa;
import br.com.dev.ecommerce.admin.empresa.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void salvar(Empresa empresa) {

		if (empresa != null) {

			try {

				this.empresaRepository.save(empresa);

			} catch (Exception e) {
				throw e;
			}
		}
	}

}
