package org.example.example3.service;

import org.example.example3.aspect.LogException;
import org.springframework.stereotype.Service;

@Service
public class MonitoredService {

    @LogException
    public void potentiallyFailingMethod() {
        // Some logic that might throw an exception
        if (true) { // example condition
            throw new RuntimeException("Oops, something went wrong!");
        }
    }
}