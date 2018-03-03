package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {

}
