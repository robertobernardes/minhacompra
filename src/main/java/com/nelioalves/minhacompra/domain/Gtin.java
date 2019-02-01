package com.nelioalves.minhacompra.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gtin", schema="minhas_compras")
public class Gtin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Long ean;	
	private String ncm;
	private Integer gpc;
	private String url;
	private boolean st_ativo;
		
	
	public Gtin() {		
	}
	
	public Gtin(Integer id, String descricao, Long ean, String ncm, Integer gpc, String url, boolean st_ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ean = ean;
		this.ncm = ncm;
		this.gpc = gpc;
		this.url = url;
		this.st_ativo = st_ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getEan() {
		return ean;
	}

	public void setEan(Long ean) {
		this.ean = ean;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Integer getGpc() {
		return gpc;
	}

	public void setGpc(Integer gpc) {
		this.gpc = gpc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isSt_ativo() {
		return st_ativo;
	}

	public void setSt_ativo(boolean st_ativo) {
		this.st_ativo = st_ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Gtin other = (Gtin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
