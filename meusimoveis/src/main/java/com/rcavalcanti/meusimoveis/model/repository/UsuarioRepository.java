package com.rcavalcanti.meusimoveis.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Optional, usuario pode ou nao existir
	//Query methods (Cria minha query por baixo)!
	//Optional<Usuario> findByEmail(String email);
	
	//select * from email where exists
	boolean existsByEmail(String email);

}
