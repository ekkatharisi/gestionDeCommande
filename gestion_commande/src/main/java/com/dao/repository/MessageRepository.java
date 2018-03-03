package com.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{

}
