package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dao.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture ,Long>{

	@Query("select f from Facture f where :x = f.livraison.id")
	public Facture findByLivraison(@Param("x")Long id);
}
