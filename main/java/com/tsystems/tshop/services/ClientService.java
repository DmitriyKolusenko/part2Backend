package com.tsystems.tshop.services;

import java.util.List;

import com.tsystems.tshop.domain.Client;

public interface ClientService {

	Client getClientById(final Long id);
	
	List<Client> getClients();

	Client getClientByName(final String name);

	Client getUser();
	
}
