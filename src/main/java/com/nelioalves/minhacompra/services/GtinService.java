package com.nelioalves.minhacompra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.minhacompra.domain.Gtin;
import com.nelioalves.minhacompra.dto.GtinDTO;
import com.nelioalves.minhacompra.repositories.GtinRepository;
import com.nelioalves.minhacompra.services.exceptions.DataIntegrityException;
import com.nelioalves.minhacompra.services.exceptions.ObjectNotFoundException;

@Service
public class GtinService {
	
	@Autowired
	private GtinRepository repo;
	
	public Gtin find(Integer id) {		
		Optional<Gtin> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Gtin.class.getName()));
	}
	
	public Gtin findByEan(Long ean) {		
		Optional<Gtin> obj = repo.findByEan(ean);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + ean + ", Tipo: " + Gtin.class.getName()));
	}
	
	public Gtin insert(Gtin obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/*public GpcTpm update(Gtin obj) {
		Gtin newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}*/
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Gtin> findAll(){
		return repo.findAll();
	}
	
	public Page<Gtin> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Gtin fromDTO(GtinDTO objDto){
		return new Gtin(objDto.getId(), objDto.getDescricao(), objDto.getEan(), objDto.getNcm(),
				objDto.getGpc(), objDto.getUrl(), objDto.isSt_ativo());
	}
	
	/*private void updateData(GpcTpm newObj, GpcTpm obj) {
		newObj.setNome(obj.getNome());
	}*/
}
