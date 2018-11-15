package com.tsystems.tshop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.tshop.domain.Product;
import com.tsystems.tshop.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(final ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/totalsaled")
	public List<Product> getTotalSaledProducts(){
		return productService.getTotalSaledProducts();
	}

}
