package com.elton.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elton.homework.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
