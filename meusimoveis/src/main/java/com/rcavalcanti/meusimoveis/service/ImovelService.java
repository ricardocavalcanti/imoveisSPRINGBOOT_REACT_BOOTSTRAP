package com.rcavalcanti.meusimoveis.service;

import java.util.List;
import java.util.Optional;

import com.rcavalcanti.meusimoveis.model.entity.Imovel;
import com.rcavalcanti.meusimoveis.model.enums.StatusImovel;

public interface ImovelService {

	Imovel salvar(Imovel imovel);

	Imovel atualizar(Imovel imovel);

	void deletar(Imovel imovel);

	List<Imovel> buscar(Imovel imovelFiltro);

	void atualizarStatus(Imovel imovelFiltro, StatusImovel statusImovel);
	
	void validar(Imovel imovelFiltro);
	
	Optional<Imovel> consultarPorId(Long id_imovel); 
}
