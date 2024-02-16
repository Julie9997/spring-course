package org.example.example3.service;

import lombok.extern.java.Log;
import org.example.example3.aspect.LoggedExecution;
import org.springframework.stereotype.Service;

@Service
@Log
public class ExampleService {

    @LoggedExecution
    public void method1() {
        log.info("method1");
    }

    public void method2() {
        log.info("method2");
    }

    @LoggedExecution
    public void method3() {
        log.info("method3");
    }

}