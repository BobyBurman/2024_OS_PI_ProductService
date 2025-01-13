package com.ospi.product.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ospi.product.dto.ProductRequest;
import com.ospi.product.dto.ProductResponse;
import com.ospi.product.model.Product;
import com.ospi.product.repository.ProductRepository;
import com.ospi.product.service.productService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class productServiceImpl implements productService{
	

	private final ProductRepository productRepository;
	

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
	   
		Product product=new Product();
		
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		
		productRepository.save(product);
		
		log.info("Product created successfully!!");
		
		return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
	}


	@Override
	public List<ProductResponse> getAllProduct() {
		
		return productRepository.findAll()
			.stream()
			.map(product-> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice()))
			.collect(Collectors.toList());
	}

}
