package com.vinsguru.rating.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinsguru.rating.dto.ProductRatingDto;
import com.vinsguru.rating.dto.ReviewDto;


@Service
public class RatingService {

	private Map<Integer, ProductRatingDto> map;
	
	 
	@PostConstruct
	private void init() {
		ProductRatingDto productRatingDto1 = ProductRatingDto.of(4.5,
                List.of(
                        ReviewDto.of("vins", "guru", 1, 5, "excellent"),
                        ReviewDto.of("marshall", "mathers", 1, 4, "decent")
                )) ;
		
		ProductRatingDto productRatingDto2 = ProductRatingDto.of(4,
	                List.of(
	                        ReviewDto.of("slim", "shady", 2, 5, "best"),
	                        ReviewDto.of("fifty", "cent", 2, 3, "")
	                )
	        );
		this.map = Map.of(1 ,productRatingDto1 ,2 ,productRatingDto2);
		
	}
	
	public ProductRatingDto getRatingForProduct(int productId) {
	        return this.map.getOrDefault(productId, new ProductRatingDto());
	}
}
