package com.nelioalves.minhacompra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.minhacompra.domain.GtinTpm;

@Repository
public interface GtinTpmRepository extends JpaRepository<GtinTpm, Integer> {

	@Transactional(readOnly=true)
	Optional<GtinTpm> findByEan(Long ean);

}
