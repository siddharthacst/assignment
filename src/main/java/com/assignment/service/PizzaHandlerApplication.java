package com.assignment.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring boot entry point.
 *
 * We can easily enhance this to add {@link RestController} and register the {@link Service} so that can be run in a {@link Servlet} container to
 * serve web requests
 * 
 * @author Sid
 *
 */
@SpringBootApplication
public class PizzaHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaHandlerApplication.class, args);
    }
}
