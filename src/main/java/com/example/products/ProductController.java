package com.example.products;

import com.example.data.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Controller("/products")
public class ProductController {

    private final InMemoryStore store;

    public ProductController(InMemoryStore inMemoryStore){
        this.store = inMemoryStore;
    }

    @Post
    public Product saveProducts(){
        return null;
    }

    @Get
    public List<Product> getAllProducts() {
        return new ArrayList<>(store.getProducts().values());
    }
}
