package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
