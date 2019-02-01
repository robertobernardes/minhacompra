package com.nelioalves.minhacompra.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.minhacompra.domain.Gtin;

public class GtinDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=500, message="O tamanho deve ser entre 1 e 500 caracteres")
	private String descricao;
	
	private Long ean;
	
	@Length(max=50, message="O tamanho deve ser no maximo 50 caracteres")
	private String ncm;
	
	private Integer gpc;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=500, message="O tamanho deve ser entre 1 e 500 caracteres")
	private String url;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private boolean st_ativo;
	
	public GtinDTO() {		
	}

	public GtinDTO(Gtin obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		ean = obj.getEan();
		ncm = obj.getNcm();
		gpc = obj.getGpc();
		url = obj.getUrl();
		st_ativo = obj.isSt_ativo();
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
		
}
