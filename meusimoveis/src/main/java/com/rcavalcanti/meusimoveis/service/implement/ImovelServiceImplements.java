package com.rcavalcanti.meusimoveis.service.implement;

import java.util.List;
import java.util.Objects;

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
	@Transactional
	public Imovel atualizar(Imovel imovel) {
		Objects.requireNonNull(imovel.getId_imovel());
		return repository.save(imovel);
	}

	@Override
	@Transactional
	public void deletar(Imovel imovel) {
		Objects.requireNonNull(imovel.getId_imovel());
		repository.delete(imovel);		
	}

	@Override
	public List<Imovel> buscar(Imovel imovelFiltro) {		
		return null;
	}

	@Override
	public void atualizarStatus(Imovel imovel, StatusImovel statusImovel) {	
		imovel.setStatusImovel(statusImovel);
		atualizar(imovel);		
	}

}
