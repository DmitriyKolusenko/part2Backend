package com.tsystems.tshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
	private Integer idClients;
	private String name;
	private String surname;
	private LocalDate dateofbirth;
	private String email;
	private String password;
	private String roles;
	private Integer idadress;
	private Adress adress;
	private ArrayList<Order> orders;
	
	public Client() {}

	public Client(final Integer idClients, final String name, final String surname, final LocalDate dateofbirth, final String email,
				  final String password, final String roles, final Integer idadress, final Adress adress){
		this.idClients = idClients;
		this.name = name;
		this.surname = surname;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.roles = roles;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public Integer getIdClients() { return idClients; }
	public void setIdClients(Integer idClients) { this.idClients = idClients; }
	public LocalDate getDateofbirth() { return dateofbirth; }
	public void setDateofbirth(LocalDate dateofbirth) { this.dateofbirth = dateofbirth; }
	public Adress getAdress() { return adress; }
	public void setAdress(Adress adress) { this.adress = adress; }
	public String getRoles() { return roles; }
	public void setRoles(String roles) { this.roles = roles; }

	@JsonIgnore
	public Integer getIdadress() {
		return idadress;
	}

	public void setIdadress(Integer idadress) {
		this.idadress = idadress;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
