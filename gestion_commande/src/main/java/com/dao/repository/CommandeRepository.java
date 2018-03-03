package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
