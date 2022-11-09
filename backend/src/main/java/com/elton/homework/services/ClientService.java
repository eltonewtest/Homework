package com.elton.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.homework.dto.ClientDTO;
import com.elton.homework.entities.Client;
import com.elton.homework.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cliRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = cliRepository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}


}
