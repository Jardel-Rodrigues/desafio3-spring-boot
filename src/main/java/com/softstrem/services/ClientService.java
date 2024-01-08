package com.softstrem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softstrem.dto.ClientDTO;
import com.softstrem.repositores.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Optional<ClientDTO> findById(Long id) {
		return repository.findById(id).map(client -> new ClientDTO(client));
	}

}
