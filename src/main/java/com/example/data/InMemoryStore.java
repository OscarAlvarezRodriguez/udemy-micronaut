package com.example.data;

import com.example.products.Product;
import jakarta.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class InMemoryStore {

    private final Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.put(product.id(), product);
        return product;
    }

}
