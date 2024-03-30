package com.mycompany.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //used to treat class as component scan class
public class PropertyManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(PropertyManagementApplication.class, args);//start tomcat server
	}

}
