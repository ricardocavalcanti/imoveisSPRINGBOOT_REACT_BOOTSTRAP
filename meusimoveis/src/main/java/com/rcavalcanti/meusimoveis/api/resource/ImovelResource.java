package com.rcavalcanti.meusimoveis.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity salvar(@RequestBody ImovelDTO dto) {
		try {
			Imovel imovel = converter(dto);
			imovel = imovelService.salvar(imovel);
			return new ResponseEntity(imovel, HttpStatus.CREATED);			
		}catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@PutMapping("{id}")	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity atualizar(@PathVariable("id") Long id_imovel, @RequestBody ImovelDTO dto) {
			return imovelService.consultarPorId(id_imovel).map(entity -> {
				try {
					Imovel imovel = converter(dto);
					imovel.setId_imovel(entity.getId_imovel());
					imovelService.atualizar(imovel);
					return ResponseEntity.ok(imovel);
				}catch (RegraNegocioException e) {
					return ResponseEntity.badRequest().body(e.getMessage());
				}
			
		}).orElseGet(() -> new ResponseEntity("Imóvel não encontrado na base de dados!", HttpStatus.BAD_REQUEST));
	}
	
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
