package com.hrtgrt.redisDatabase.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.hrtgrt.redisDatabase.entity.Product;

@Repository
public class ProductRepo {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public Product save(Product product) {
		redisTemplate.opsForHash().put("Product", product.getId(), product);
		
		return product;
	}
	
	
	public List<Object> getAll() {
		return redisTemplate.opsForHash().values("Product");
	}
	
	public Object getProduct(Integer id) {
		return redisTemplate.opsForHash().get("Product", id);
	}
	
	public String delete(Integer id) {
		redisTemplate.opsForHash().delete("Product", id);
		
		return "Product Deleted";
	}
	
	
}
