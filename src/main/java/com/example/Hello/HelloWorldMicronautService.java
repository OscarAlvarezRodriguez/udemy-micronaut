package com.example.Hello;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Singleton
public class HelloWorldMicronautService implements MyService {

    @Override
    public String HelloFromService() {
        return "hello world from micronaut!";
    }
}
