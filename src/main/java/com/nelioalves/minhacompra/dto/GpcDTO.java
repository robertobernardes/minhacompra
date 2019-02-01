package com.nelioalves.minhacompra.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.minhacompra.domain.Gpc;

public class GpcDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=200, message="O tamanho deve ser entre 1 e 200 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Long codigo;
	
	@Length(max=200, message="O tamanho deve ser no maximo 200 caracteres")
	private String link;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private boolean st_ativo;
	
	public GpcDTO() {		
	}
	
	public GpcDTO(Gpc obj) {
		id = obj.getId();
		nome = obj.getNome();
		codigo = obj.getCodigo();
		link = obj.getLink();
		st_ativo = obj.isSt_ativo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isSt_ativo() {
		return st_ativo;
	}

	public void setSt_ativo(boolean st_ativo) {
		this.st_ativo = st_ativo;
	}	
}
