package com.tsystems.tshop.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tsystems.tshop.domain.Client;
import com.tsystems.tshop.services.ClientService;

@Controller
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*", maxAge = 3600,
        allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
public class ClientController {

	private final ClientService clientService;

	public ClientController(final ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@ResponseBody
	public Client getClient(@PathVariable Long id) {
		return clientService.getClientById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getClients() {
		return clientService.getClients();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/user")
	@ResponseBody
	public Client getUser() {
		return clientService.getUser();
	}
}
