package com.hrtgrt.redisDatabase.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor	
@NoArgsConstructor
@RedisHash("product")
public class Product implements Serializable{
	
	@Id
	private Integer id;
	private String name;
	private String about;
	private Integer qty;
	private Long price;
	
}
