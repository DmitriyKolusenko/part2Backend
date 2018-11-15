package com.tsystems.tshop.repositories;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tsystems.tshop.domain.Adress;
import com.tsystems.tshop.domain.Order;
import com.tsystems.tshop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.tsystems.tshop.domain.Client;

@PropertySource("classpath:queries/client-queries.xml")
@Repository
public class ClientRepository {
	
	@Autowired
	private Environment env;
	
	private static final String GET_CLIENT_BY_ID_QUERY = "getClientById";
	private static final String GET_ALL_CLIENTS_QUERY = "getAllClients";
	private static final String GET_CLIENT_ADRESS_BY_ID = "getAdressById";
	private static final String GET_CLIENT_BY_NAME_QUERY = "getClientByName";
	private static final String GET_CLIENT_ORDERS = "getOrdersByClient";
	private static final String GET_ORDERED_PRODUCT_BY_ID = "getProductById";
	
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public ClientRepository(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public Client getClient(final Long id) {
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", id);
		Client client = namedParameterJdbcTemplate.queryForObject(env.getProperty(GET_CLIENT_BY_ID_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(Client.class));
		client.setAdress(getAdressById(client.getIdadress()));
		client.setOrders(getClientOrders(client.getIdClients()));
		return client;
	}

	public Client getClientByName(final String name) {
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name",name);
		System.out.println("=========================" + name);
		Client client = namedParameterJdbcTemplate.queryForObject(env.getProperty(GET_CLIENT_BY_NAME_QUERY),
				sqlParameterSource,BeanPropertyRowMapper.newInstance(Client.class));
		client.setAdress(getAdressById(client.getIdadress()));
		client.setOrders(getClientOrders(client.getIdClients()));
		return client;
	}
	
	public List<Client> getAllUsers() {
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		List<Client> list = namedParameterJdbcTemplate.query(env.getProperty(GET_ALL_CLIENTS_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(Client.class));
		for (int i=0; i<list.size(); i++){
			list.get(i).setAdress(getAdressById(list.get(i).getIdadress()));
		}
		 return list;
	}

	public Adress getAdressById(final Integer id){
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("idclientadress",id);
		return namedParameterJdbcTemplate.queryForObject(env.getProperty(GET_CLIENT_ADRESS_BY_ID), sqlParameterSource,
				BeanPropertyRowMapper.newInstance(Adress.class));
	}

	public ArrayList<Order> getClientOrders(final Integer id){
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("idclient",id);
		List<Order> list = namedParameterJdbcTemplate.query(env.getProperty(GET_CLIENT_ORDERS), sqlParameterSource,
				BeanPropertyRowMapper.newInstance(Order.class));
		HashMap<Integer,Order> mapOrder = new HashMap<>();
		for (Order order: list){
			Product product = getProductById(order.getProduct_Id());
			product.setCount(order.getCount());
			if (mapOrder.containsKey(order.getOrdernumber())){
				mapOrder.get(order.getOrdernumber()).getProducts().add(product);
			}else {
				order.getProducts().add(product);
				mapOrder.put(order.getOrdernumber(),order);
			}
		}
		return new ArrayList<>(mapOrder.values());
	}

	public Product getProductById(final Integer id){
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id",id);
		return namedParameterJdbcTemplate.queryForObject(env.getProperty(GET_ORDERED_PRODUCT_BY_ID), sqlParameterSource,
				BeanPropertyRowMapper.newInstance(Product.class));
	}
}
