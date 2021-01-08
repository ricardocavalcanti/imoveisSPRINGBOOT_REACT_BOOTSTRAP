package com.rcavalcanti.meusimoveis.service.implement;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcavalcanti.meusimoveis.exception.RegraNegocioException;
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
		validar(imovel);
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
	@Transactional(readOnly = true)
	@SuppressWarnings({ "rawtypes", "unused" })
	public List<Imovel> buscar(Imovel imovelFiltro) {
		Example example = Example.of(imovelFiltro, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll();
	}

	@Override
	public void atualizarStatus(Imovel imovel, StatusImovel statusImovel) {	
		imovel.setStatusImovel(statusImovel);
		validar(imovel);
		atualizar(imovel);		
	}

	@Override
	public void validar(Imovel imovel) {
		if(imovel.getStatusImovel()==null) {
			throw new RegraNegocioException("Informe um Status válido para o imóvel!");
		}else if(imovel.getDescricao()==null || imovel.getDescricao().trim().equals("")) {
			throw new RegraNegocioException("Informe uma Descrição válida!");			
		}else if(imovel.getRua()==null || imovel.getRua().trim().equals("")) {
			throw new RegraNegocioException("Informe uma Rua válida!");
		}else if(imovel.getCep()==null) {
			throw new RegraNegocioException("Informe uma CEP válido!");
		}else if(imovel.getNumero()==null) {
			throw new RegraNegocioException("Informe um Número válido!");
		}else if(imovel.getUsuario()==null || imovel.getUsuario().getId_usuario()==null) {
			throw new RegraNegocioException("Informe um Número válido!");
		}			
	}

	@Override
	public Optional<Imovel> consultarPorId(Long id_imovel) {		
		return repository.findById(id_imovel);
	}

}
