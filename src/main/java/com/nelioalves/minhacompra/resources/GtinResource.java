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

import com.nelioalves.minhacompra.domain.Gtin;
import com.nelioalves.minhacompra.dto.GtinDTO;
import com.nelioalves.minhacompra.services.GtinService;

@RestController
@RequestMapping(value = "/gtin")
public class GtinResource {

	@Autowired
	private GtinService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Gtin> find(@PathVariable Integer id) {
		Gtin obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/ean/{ean}", method = RequestMethod.GET)
	public ResponseEntity<Gtin> find(@PathVariable Long ean) {
		Gtin obj = service.findByEan(ean);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GtinDTO>> findAll() {
		List<Gtin> list = service.findAll();
		List<GtinDTO> listDto = list.stream().map(obj -> new GtinDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<GtinDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Gtin> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<GtinDTO> listDto = list.map(obj -> new GtinDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
