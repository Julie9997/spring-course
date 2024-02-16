package org.example.example3;

import org.example.example3.service.ExampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example3Application {

    public static void main(String[] args) {
        SpringApplication.run(Example3Application.class, args);

        var c = new AnnotationConfigApplicationContext(Example3Application.class);
        var service = c.getBean(ExampleService.class);
        service.method1();
        service.method2();
        service.method3();
    }

}
