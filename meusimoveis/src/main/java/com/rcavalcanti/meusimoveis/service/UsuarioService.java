package com.rcavalcanti.meusimoveis.service;

import java.util.Optional;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;

public interface UsuarioService {

	Usuario autenticar(String email, String senha);

	Usuario salvarUsuario(Usuario usuario);

	void validarEmail(String email);
	
	Optional<Usuario> consultarPorId(Long id_usuario);
}
