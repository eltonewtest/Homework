package com.elton.homework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.homework.entities.Client;
import com.elton.homework.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cliRepository;

	@Transactional(readOnly = true)
	public List<Client> findAll() {
		
		return cliRepository.findAll();
	}
	
	
	
	
}
