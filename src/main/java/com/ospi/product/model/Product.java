package com.ospi.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value="product")
public class Product {
	
	@Id
	private String id;
	
	@Field(value="name")
	private String name;
	
	private String description;
	
	private String price;

}
