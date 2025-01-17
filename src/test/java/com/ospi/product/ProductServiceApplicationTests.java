package com.ospi.product;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;



import io.restassured.RestAssured;


import io.restassured.config.RestAssuredConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ProductServiceApplicationTests {
	
	
	//To create light weighted real test instances for mongodb using docker and also dependency for test container rest call
	/*@ServiceConnection
	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:7.0.5");*/
							
						/*or - when use docker hub instances */
	
	//Bean defined in TestConfiguration class
	//static MongoDBContainer mongoDBContainer;
	
	@LocalServerPort
	private Integer port;
	
	@Before
	void setup() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;
		log.info("*************port************"+port);
	}
	
//	static {
//		mongoDBContainer.start();
//	}
	
	@Test
	void createProductTest() {

		String testRequestBody = """
				{
				   "name":"iPhone",
				   "description":"iPhone 15 max pro",
				   "price": "1000"
				}
			
											""";
		// Configuring RestAssured to encode the body as JSON
	    RestAssuredConfig config = RestAssured.config()
	        .encoderConfig(new EncoderConfig().encodeContentTypeAs("application/json", ContentType.JSON));
	    
	    
		RestAssured.given()
				.config(config)
				.contentType(ContentType.JSON)
				.body(testRequestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
     			.body("id",Matchers.notNullValue())
				.body("name", Matchers.equalTo("iPhone"))
				.body("description",Matchers.equalTo("iPhone 15 max pro"))
				.body("price",Matchers.equalTo("1000"));
	}
	
        
}

