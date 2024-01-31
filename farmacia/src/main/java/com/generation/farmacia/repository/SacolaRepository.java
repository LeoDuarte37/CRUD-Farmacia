package com.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Sacola;

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long>{

}
