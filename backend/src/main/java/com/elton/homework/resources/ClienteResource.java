package com.elton.homework.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elton.homework.entities.Client;
import com.elton.homework.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClienteResource {

	@Autowired
	private ClientService cliService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = cliService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
