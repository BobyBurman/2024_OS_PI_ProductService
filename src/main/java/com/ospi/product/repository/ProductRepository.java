package com.ospi.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ospi.product.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

}
