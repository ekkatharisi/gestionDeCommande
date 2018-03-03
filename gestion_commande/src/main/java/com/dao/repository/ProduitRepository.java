package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long > {

}
