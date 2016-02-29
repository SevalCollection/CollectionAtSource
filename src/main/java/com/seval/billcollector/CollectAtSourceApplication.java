package com.seval.billcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.seval.billcollector.repository")
@EntityScan(basePackages = "com.seval.billcollector.model")
public class CollectAtSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectAtSourceApplication.class, args);
	}
}
