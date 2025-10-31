package com.example.Hello;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService {

    public String HelloFromService() {
        return "hello world from service!";
    }
}
