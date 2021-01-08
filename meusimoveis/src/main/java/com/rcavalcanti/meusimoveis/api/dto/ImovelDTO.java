package com.rcavalcanti.meusimoveis.api.dto;

import java.math.BigDecimal;

import com.rcavalcanti.meusimoveis.model.enums.StatusImovel;

public class ImovelDTO {

	private Long id_imovel;

	private Long id_usuario;

	private StatusImovel statusImovel;

	private String descricao;

	private Integer quantidade_quartos;

	private Integer quantidade_banheiros;

	private BigDecimal valor_aluguel;

	private BigDecimal valor_venda;

	private Integer ano;

	private Integer area;

	private String telefone;

	private String rua;

	private Integer numero;

	private Integer cep;

	private String cidade;

	private String estado;
	

	public Long getId_imovel() {
		return id_imovel;
	}

	public void setId_imovel(Long id_imovel) {
		this.id_imovel = id_imovel;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public StatusImovel getStatusImovel() {
		return statusImovel;
	}

	public void setStatusImovel(StatusImovel statusImovel) {
		this.statusImovel = statusImovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade_quartos() {
		return quantidade_quartos;
	}

	public void setQuantidade_quartos(Integer quantidade_quartos) {
		this.quantidade_quartos = quantidade_quartos;
	}

	public Integer getQuantidade_banheiros() {
		return quantidade_banheiros;
	}

	public void setQuantidade_banheiros(Integer quantidade_banheiros) {
		this.quantidade_banheiros = quantidade_banheiros;
	}

	public BigDecimal getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(BigDecimal valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
