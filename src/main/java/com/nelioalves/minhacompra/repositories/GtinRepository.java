package com.nelioalves.minhacompra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.minhacompra.domain.Gtin;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Integer> {

	@Transactional(readOnly=true)
	Optional<Gtin> findByEan(Long ean);

}
