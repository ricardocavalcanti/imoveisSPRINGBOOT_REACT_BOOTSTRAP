package com.rcavalcanti.meusimoveis.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rcavalcanti.meusimoveis.model.enums.StatusImovel;

@Entity
@Table(name = "tb_imovel", schema = "imoveis")
public class Imovel {

	@Id
	@Column(name = "id_imovel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_imovel;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;
	
	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private StatusImovel statusImovel;  
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "quantidade_quarto")
	private Integer quantidade_quartos;
	
	@Column(name = "quantidade_banheiros")
	private Integer quantidade_banheiros;
	
	@Column(name = "valor_aluguel")
	private BigDecimal valor_aluguel; 
	
	@Column(name = "valor_venda")
	private BigDecimal valor_venda; 
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "area")
	private Integer area;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "cep")
	private Integer cep;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String estado;
	

	public Long getId_imovel() {
		return id_imovel;
	}

	public void setId_imovel(Long id_imovel) {
		this.id_imovel = id_imovel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id_imovel == null) ? 0 : id_imovel.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((quantidade_banheiros == null) ? 0 : quantidade_banheiros.hashCode());
		result = prime * result + ((quantidade_quartos == null) ? 0 : quantidade_quartos.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((statusImovel == null) ? 0 : statusImovel.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valor_aluguel == null) ? 0 : valor_aluguel.hashCode());
		result = prime * result + ((valor_venda == null) ? 0 : valor_venda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_imovel == null) {
			if (other.id_imovel != null)
				return false;
		} else if (!id_imovel.equals(other.id_imovel))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (quantidade_banheiros == null) {
			if (other.quantidade_banheiros != null)
				return false;
		} else if (!quantidade_banheiros.equals(other.quantidade_banheiros))
			return false;
		if (quantidade_quartos == null) {
			if (other.quantidade_quartos != null)
				return false;
		} else if (!quantidade_quartos.equals(other.quantidade_quartos))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (statusImovel != other.statusImovel)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valor_aluguel == null) {
			if (other.valor_aluguel != null)
				return false;
		} else if (!valor_aluguel.equals(other.valor_aluguel))
			return false;
		if (valor_venda == null) {
			if (other.valor_venda != null)
				return false;
		} else if (!valor_venda.equals(other.valor_venda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Imovel [id_imovel=" + id_imovel + ", usuario=" + usuario + ", statusImovel=" + statusImovel
				+ ", descricao=" + descricao + ", quantidade_quartos=" + quantidade_quartos + ", quantidade_banheiros="
				+ quantidade_banheiros + ", valor_aluguel=" + valor_aluguel + ", valor_venda=" + valor_venda + ", ano="
				+ ano + ", area=" + area + ", telefone=" + telefone + ", rua=" + rua + ", numero=" + numero + ", cep="
				+ cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}	

}
