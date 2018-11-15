package com.tsystems.tshop.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tsystems.tshop.domain.Product;
import com.tsystems.tshop.repositories.ProductRepository;
import com.tsystems.tshop.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	public ProductServiceImpl(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product getProductById(final Integer id) {
		return productRepository.getProductById(id);
	}
	
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	public List<Product> getTotalSaledProducts() {
		return productRepository.getTotalSaledProducts();
	}

}
