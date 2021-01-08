package com.rcavalcanti.meusimoveis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcavalcanti.meusimoveis.model.entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

}
