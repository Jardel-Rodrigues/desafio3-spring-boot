package com.softstrem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softstrem.dto.ClientDTO;
import com.softstrem.repositores.ClientRepository;
import com.softstrem.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		return repository.findById(id).map(client -> new ClientDTO(client))
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
	}

}
