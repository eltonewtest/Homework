package com.elton.homework.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.homework.dto.ClientDTO;
import com.elton.homework.entities.Client;
import com.elton.homework.repositories.ClientRepository;
import com.elton.homework.services.exceptions.DatabaseException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cliRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = cliRepository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> cliObj = cliRepository.findById(id);
		Client entity = cliObj.orElseThrow(() -> new DatabaseException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setIncome(dto.getIncome());
		cliRepository.save(entity);
	
		return new ClientDTO(entity);
	}

}
