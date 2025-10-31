package com.example.Hello;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@Controller("/hello")
public class HelloWorldController {

    private final HelloWorldService Service;

    public HelloWorldController(final HelloWorldService service) {
        this.Service = service;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld(){
        return Service.HelloFromService();
    }
}
