package com.nelioalves.minhacompra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.minhacompra.domain.Gpc;

@Repository
public interface GpcRepository extends JpaRepository<Gpc, Integer> {

}
