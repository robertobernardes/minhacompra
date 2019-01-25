package com.nelioalves.minhacompra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.minhacompra.domain.Gpc;
import com.nelioalves.minhacompra.dto.GpcDTO;
import com.nelioalves.minhacompra.repositories.GpcRepository;
import com.nelioalves.minhacompra.services.exceptions.DataIntegrityException;
import com.nelioalves.minhacompra.services.exceptions.ObjectNotFoundException;

@Service
public class GpcService {
	
	@Autowired
	private GpcRepository repo;
	
	public Gpc find(Integer id) {		
		Optional<Gpc> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Gpc.class.getName()));
	}
	
	public Gpc insert(Gpc obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Gpc update(Gpc obj) {
		Gpc newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Gpc> findAll(){
		return repo.findAll();
	}
	
	public Page<Gpc> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Gpc fromDTO(GpcDTO objDto){
		return new Gpc(objDto.getId(), objDto.getNome(), objDto.getCodigo(), objDto.getLink(), objDto.isSt_ativo());
	}
	
	private void updateData(Gpc newObj, Gpc obj) {
		newObj.setNome(obj.getNome());
	}
}
