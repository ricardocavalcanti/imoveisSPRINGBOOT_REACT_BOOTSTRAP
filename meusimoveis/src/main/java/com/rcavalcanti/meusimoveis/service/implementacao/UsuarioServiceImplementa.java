package com.rcavalcanti.meusimoveis.service.implementacao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcavalcanti.meusimoveis.exception.RegraNegocioException;
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
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {	
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	//Vai na base de dados validar o email atraves do repository que foi injetado
	@Override
	public void validarEmail(String email) {		
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email!");
		}
	}

}
