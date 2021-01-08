package com.rcavalcanti.meusimoveis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcavalcanti.meusimoveis.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
