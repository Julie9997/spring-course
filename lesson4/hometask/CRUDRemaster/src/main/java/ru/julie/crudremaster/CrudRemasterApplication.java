package ru.julie.crudremaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("ru.julie.crudremaster.models")
@SpringBootApplication
public class CrudRemasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRemasterApplication.class, args);
	}

}
