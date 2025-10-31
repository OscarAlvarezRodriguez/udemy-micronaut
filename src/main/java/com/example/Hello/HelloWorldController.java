package com.example.Hello;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@Controller("/hello")
public class HelloWorldController {

    private final MyService Service;

    public HelloWorldController(final MyService service) {
        this.Service = service;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld(){
        return Service.HelloFromService();
    }
}
