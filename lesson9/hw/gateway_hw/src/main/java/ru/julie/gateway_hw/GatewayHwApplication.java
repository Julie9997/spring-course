package ru.julie.gateway_hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayHwApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("NoteService", r -> r.path("/noteService/**")
						.uri("http://localhost:8081/"))
				.route("TaskService", r -> r.path("/taskService/**")
						.uri("http://localhost:8082/")).build();
	}
}
