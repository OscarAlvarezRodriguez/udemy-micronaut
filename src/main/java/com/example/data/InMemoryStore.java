package com.example.data;

import com.example.products.Product;
import jakarta.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class InMemoryStore {

    private final Map<String, Product> products = new HashMap<>();

    public Map<String, Product> getProducts() {
        return products;
    }
}
