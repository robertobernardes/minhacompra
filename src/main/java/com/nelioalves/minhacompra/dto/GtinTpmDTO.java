package com.nelioalves.minhacompra.dto;

import java.io.Serializable;

import com.nelioalves.minhacompra.domain.GtinTpm;

public class GtinTpmDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;		
	private Long ean;
	
	public GtinTpmDTO() {		
	}
	
	public GtinTpmDTO(GtinTpm obj) {
		id = obj.getId();
		ean = obj.getEan();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getEan() {
		return ean;
	}

	public void setCodigo(Long ean) {
		this.ean = ean;
	}	
}
