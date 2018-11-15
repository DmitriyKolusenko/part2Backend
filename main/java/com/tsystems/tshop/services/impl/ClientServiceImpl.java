package com.tsystems.tshop.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tsystems.tshop.domain.Client;
import com.tsystems.tshop.repositories.ClientRepository;
import com.tsystems.tshop.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	private Client client;
	
	private final ClientRepository clientRepository;
	
	public ClientServiceImpl(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client getClientById(final Long id) {
		return clientRepository.getClient(id);
	}

	public List<Client> getClients() {
		return clientRepository.getAllUsers();
	}

	public Client getClientByName(String name) {
		client = clientRepository.getClientByName(name);
		return client;
	}

	public Client getUser(){ return client; }
}
