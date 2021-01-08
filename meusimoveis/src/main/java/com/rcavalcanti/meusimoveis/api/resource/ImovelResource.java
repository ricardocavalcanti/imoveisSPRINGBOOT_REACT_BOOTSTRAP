package com.rcavalcanti.meusimoveis.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity buscar( @RequestParam(value="descricao", required = false) String descricao, 
			@RequestParam(value="rua",required = false) String rua, @RequestParam(value="cep",required = false) Integer cep, 
			@RequestParam("usuario") Long id_usuario) {
		
			Imovel imovelFiltro = new Imovel();
			imovelFiltro.setDescricao(descricao);
			imovelFiltro.setRua(rua);
			imovelFiltro.setCep(cep);
			
			Optional<Usuario> usuario = usuarioService.consultarPorId(id_usuario);
			if(usuario.isPresent()) {
				return ResponseEntity.badRequest().body("Não foi possível realizar a conssulta, usuário não encontrado para o Id informado!");
			}else {
				imovelFiltro.setUsuario(usuario.get());
			}
			
			List<Imovel> imoveis = imovelService.buscar(imovelFiltro);
			return ResponseEntity.ok(imoveis);
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
	
	@DeleteMapping("{id}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity deletar(@PathVariable("id") Long id_imovel) {
		return imovelService.consultarPorId(id_imovel).map( entity -> {
			imovelService.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
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
