package com.vinsguru.product.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vinsguru.product.dto.ProductDto;
import com.vinsguru.product.dto.ProductRatingDto;
import com.vinsguru.product.entity.Product;

@Service
public class ProductService {

	private Map<Integer, Product> map;
	
	 @Autowired
	 private RatingServiceClient ratingServiceClient;
	 
	@PostConstruct
	private void init() {
	
		this.map = new HashMap<Integer, Product>();
		this.map.put(1, Product.of(1, "Blood On The Dance Floor", 12.45));		
	}
	
	public ProductDto getProductDto(int productId) {
		ProductRatingDto ratingDto = this.ratingServiceClient.getProductRatingDto(1);
		Product product = this.map.get(productId);
		
		return ProductDto.of(productId, product.getDescription(), product.getPrice(), ratingDto);
	}
}
	
