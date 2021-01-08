package com.rcavalcanti.meusimoveis.api.resource;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcavalcanti.meusimoveis.api.dto.ImovelDTO;
import com.rcavalcanti.meusimoveis.exception.RegraNegocioException;
import com.rcavalcanti.meusimoveis.model.entity.Imovel;
import com.rcavalcanti.meusimoveis.model.entity.Usuario;
import com.rcavalcanti.meusimoveis.model.enums.StatusImovel;
import com.rcavalcanti.meusimoveis.service.ImovelService;
import com.rcavalcanti.meusimoveis.service.UsuarioService;

//Meu Controller
@RestController
@RequestMapping("/api/imoveis")
public class ImovelResource {
	
	private ImovelService imovelService;
	
	private UsuarioService usuarioService;
	
	public ImovelResource(ImovelService imovelService) {
		this.imovelService = imovelService;		
	}
	
//	@PostMapping
//	public ResponseEntity salvar(@RequestBody ImovelDTo dto) {
//		
//	}
	
	private Imovel converter(ImovelDTO dto) {
		Imovel imovel = new Imovel();
		imovel.setAno(dto.getAno());
		imovel.setArea(dto.getArea());
		imovel.setCep(dto.getCep());
		imovel.setCidade(dto.getCidade());
		imovel.setDescricao(dto.getDescricao());
		imovel.setEstado(dto.getEstado());
		imovel.setId_imovel(dto.getId_imovel());
		imovel.setNumero(dto.getNumero());
		imovel.setQuantidade_banheiros(dto.getQuantidade_banheiros());
		imovel.setQuantidade_quartos(dto.getQuantidade_quartos());
		imovel.setRua(dto.getRua());
		imovel.setStatusImovel(StatusImovel.valueOf(dto.getStatusImovel()));
		imovel.setTelefone(dto.getTelefone());	
		Usuario usuario = usuarioService.consultarPorId(dto.getId_usuario()).orElseThrow(() -> new RegraNegocioException("Usuário não encontrado para o Id informado!"));		
		imovel.setUsuario(usuario);
		imovel.setValor_aluguel(dto.getValor_aluguel());
		imovel.setValor_venda(dto.getValor_venda());	
		return imovel;		
	}
}
