package com.ospi.product;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	/*
	 * @Bean
	 * 
	 * @ServiceConnection // Annotation used to dynamically defined mongodb url(host
	 * & port) from appliaction.properties file MongoDBContainer mongoDbContainer()
	 * { return new MongoDBContainer(DockerImageName.parse("mongo:latest")); }
	 */

}
