package com.ospi.product.service;

import java.util.List;

import com.ospi.product.dto.ProductRequest;
import com.ospi.product.dto.ProductResponse;


public interface productService {

	ProductResponse createProduct(ProductRequest productRequest);

	List<ProductResponse> getAllProduct();

}
