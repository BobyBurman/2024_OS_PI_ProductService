package com.ospi.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ospi.product.dto.ProductRequest;
import com.ospi.product.dto.ProductResponse;
import com.ospi.product.service.productService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/product", method=RequestMethod.GET)
@RequiredArgsConstructor
public class productController {
	
	private final productService productService;
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<ProductResponse>(productService.createProduct(productRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProduct(){
		return productService.getAllProduct();
	}
	
	
	

}
