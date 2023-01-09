package com.hrtgrt.redisDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrtgrt.redisDatabase.entity.Product;
import com.hrtgrt.redisDatabase.repository.ProductRepo;

@RestController
@RequestMapping("/product")
public class productController {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	//Save Product
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product savedProduct = this.productRepo.save(product);
		
		return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
	}
	
	
	//Get All Products
	@GetMapping("/")
	public ResponseEntity<List<Object>> getAllProduct() {
		List<Object> allProducts = this.productRepo.getAll();
		
		return new ResponseEntity<List<Object>>(allProducts, HttpStatus.OK);
	}
	
	
	//Get a Product
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable Integer id) {
		Object product = this.productRepo.getProduct(id);
		
		return new ResponseEntity<Object>(product, HttpStatus.OK);
	}
	
	//Delete a Product
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		String msg = this.productRepo.delete(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
