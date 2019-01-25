package com.nelioalves.minhacompra.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gpc", schema="minhas_compras")
public class Gpc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Long codigo;
	private String link;
	private boolean st_ativo;
		
	//@ManyToMany(mappedBy="gpcs")	
	//private List<Gpc> gpcs = new ArrayList<>();
	
	public Gpc() {		
	}
	
	public Gpc(Integer id, String nome, Long codigo, String link, boolean st_ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.link = link;
		this.st_ativo = st_ativo;
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
		Gpc other = (Gpc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
