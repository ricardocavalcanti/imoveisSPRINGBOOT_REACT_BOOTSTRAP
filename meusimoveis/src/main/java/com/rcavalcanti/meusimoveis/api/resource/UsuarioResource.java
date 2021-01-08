package com.rcavalcanti.meusimoveis.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcavalcanti.meusimoveis.api.dto.UsuarioDTO;
import com.rcavalcanti.meusimoveis.exception.RegraNegocioException;
import com.rcavalcanti.meusimoveis.model.entity.Usuario;
import com.rcavalcanti.meusimoveis.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

//	@GetMapping("/")
//	public String helloWorld() {
//		return "Hello World!";
//	}
	
	private UsuarioService service;
	
	public UsuarioResource(UsuarioService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody  UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());		
		try {
		 Usuario usuarioSalvo = service.salvarUsuario(usuario);
		 return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED );
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
