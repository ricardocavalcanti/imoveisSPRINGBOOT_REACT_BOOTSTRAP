package com.rcavalcanti.meusimoveis.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;
import com.rcavalcanti.meusimoveis.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveValidarEmail() {
		//Ver como implementar no jUnit5 para saber se exception nao eh lancada
		//Cenario
		repository.deleteAll();
		//Acao
		service.validarEmail("email@email.com");
	}
	
	@Test
	public void deveLancarErroQuandoExistirEmailCadastrado() {
		//Ver como implementar no jUnit5 para saber se exception eh lancada
		//Cenario
		Usuario usuario = new Usuario();
		usuario.setNome("usuario");
		usuario.setEmail("email@email.com");
		repository.save(usuario);
		//Acao
		service.validarEmail("email@email.com");
	}
	

}
