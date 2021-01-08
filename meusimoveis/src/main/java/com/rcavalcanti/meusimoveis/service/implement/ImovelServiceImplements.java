package com.rcavalcanti.meusimoveis.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcavalcanti.meusimoveis.model.entity.Imovel;
import com.rcavalcanti.meusimoveis.model.enums.StatusImovel;
import com.rcavalcanti.meusimoveis.model.repository.ImovelRepository;
import com.rcavalcanti.meusimoveis.service.ImovelService;

@Service
public class ImovelServiceImplements implements ImovelService {	
	
	private ImovelRepository repository;
	
	public ImovelServiceImplements(ImovelRepository repository) {
		this.repository = repository;		
	}

	@Override
	@Transactional
	public Imovel salvar(Imovel imovel) {		
		return repository.save(imovel);
	}

	@Override
	public Imovel atualizar(Imovel imovel) {		
		return null;
	}

	@Override
	public void deletar(Imovel imovel) {		
		
	}

	@Override
	public List<Imovel> buscar(Imovel imovelFiltro) {		
		return null;
	}

	@Override
	public void atualizarStatus(Imovel imovelFiltro, StatusImovel statusImovel) {		
		
	}

}
