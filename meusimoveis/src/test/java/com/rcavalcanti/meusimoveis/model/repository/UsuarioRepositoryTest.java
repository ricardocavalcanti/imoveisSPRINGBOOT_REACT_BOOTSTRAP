package com.rcavalcanti.meusimoveis.model.repository;


//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	//Testes na camada Repository sao de integracao
	
	@Autowired
	UsuarioRepository repository;
	
//	@Test
//	public void deveVerificarExistenciaDeEmail() {		
//		//Cenario		 
//		ccccc		
//		//Acao e execucao
//		boolean result = repository.existsByEmail("usuario@email.com");		
//		//Verificacao
//		Assertions.assertThat(result).isTrue();		
//	}
//	
//	@Test
//	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {		
//		//Cenario	
//		repository.deleteAll();		
//		//Acao e execucao
//		boolean result = repository.existsByEmail("usuario@email.com");		
//		//Verificacao
//		Assertions.assertThat(result).isFalse();		
//	}
	
//	@Test
//	public void devePersistirUsuarioNaBaseDados() {		
//		//Cenario	
//		Usuario usuario = criarUsuario();
//		usuario.setNome("usuario");
//		usuario.setEmail("usuario@email.com");
//		usuario.setSenha("senha");				
//		//Acao e execucao
//		Usuario usuarioSalvo = repository.save(usuario);
//		//Verificacao
//		Assertions.assertThat(usuarioSalvo.getId_usuario()).isNotNull();		
//	}
	
//	@Test
//	public void deveBuscarUsuarioPorEmail() {		
//		//Cenario	
//		Usuario usuario = criarUsuario();					
//		//Acao e execucao
//		Usuario usuarioSalvo = repository.save(usuario);
//		//Verificacao
//		Assertions.assertThat(usuarioSalvo.getId_usuario()).isNotNull();		
//	}
	
	public static Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("usuario");
		usuario.setEmail("usuario@email.com");
		usuario.setSenha("senha");
		return usuario;
		
	}
}
