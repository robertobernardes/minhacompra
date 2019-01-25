package com.nelioalves.minhacompra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.minhacompra.domain.GtinTpm;
import com.nelioalves.minhacompra.dto.GtinTpmDTO;
import com.nelioalves.minhacompra.repositories.GtinTpmRepository;
import com.nelioalves.minhacompra.services.exceptions.DataIntegrityException;
import com.nelioalves.minhacompra.services.exceptions.ObjectNotFoundException;

@Service
public class GtinTpmService {
	
	@Autowired
	private GtinTpmRepository repo;
	
	public GtinTpm find(Integer id) {		
		Optional<GtinTpm> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + GtinTpm.class.getName()));
	}
	
	public GtinTpm findByEan(Long ean) {		
		Optional<GtinTpm> obj = repo.findByEan(ean);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + ean + ", Tipo: " + GtinTpm.class.getName()));
	}
	
	public GtinTpm insert(GtinTpm obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/*public GpcTpm update(GpcTpm obj) {
		GpcTpm newObj = find(obj.getId());
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
	
	public List<GtinTpm> findAll(){
		return repo.findAll();
	}
	
	public Page<GtinTpm> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public GtinTpm fromDTO(GtinTpmDTO objDto){
		return new GtinTpm(objDto.getId(), objDto.getEan());
	}
	
	/*private void updateData(GpcTpm newObj, GpcTpm obj) {
		newObj.setNome(obj.getNome());
	}*/
}
