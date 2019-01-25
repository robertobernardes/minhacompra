package com.nelioalves.minhacompra.resources;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.minhacompra.domain.GtinTpm;
import com.nelioalves.minhacompra.dto.GtinTpmDTO;
import com.nelioalves.minhacompra.services.GtinTpmService;

@RestController
@RequestMapping(value="/gtintpms")
public class GtinTpmResource {
	
	@Autowired
	private GtinTpmService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<GtinTpm> find(@PathVariable Integer id) {
		GtinTpm obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value="/ean/{ean}", method=RequestMethod.GET)
	public ResponseEntity<GtinTpm> find(@PathVariable Long ean) {
		GtinTpm obj = service.findByEan(ean);
		return ResponseEntity.ok().body(obj);		
	}
			
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GtinTpmDTO>> findAll() {
		List<GtinTpm> list = service.findAll();
		List<GtinTpmDTO> listDto = list.stream().map(obj -> new GtinTpmDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);		
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<GtinTpmDTO>> findPage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction
			) {
		
		Page<GtinTpm> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<GtinTpmDTO> listDto = list.map(obj -> new GtinTpmDTO(obj));
		return ResponseEntity.ok().body(listDto);		
	}
}
