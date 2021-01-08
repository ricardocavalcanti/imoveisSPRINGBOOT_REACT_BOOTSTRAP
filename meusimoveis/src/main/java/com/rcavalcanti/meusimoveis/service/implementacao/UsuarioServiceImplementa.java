package com.rcavalcanti.meusimoveis.service.implementacao;

import org.springframework.stereotype.Service;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;
import com.rcavalcanti.meusimoveis.model.repository.UsuarioRepository;
import com.rcavalcanti.meusimoveis.service.UsuarioService;

@Service
public class UsuarioServiceImplementa implements UsuarioService {	
	
	private UsuarioRepository repository;	
	
	public UsuarioServiceImplementa(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {		
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {		
		return null;
	}

	@Override
	public void validarEmail(String email) {		
		
	}

}
