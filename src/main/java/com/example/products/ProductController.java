package com.example.products;

import com.example.data.InMemoryStore;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller("/products")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class ProductController {

    private final InMemoryStore store;

    public ProductController(InMemoryStore inMemoryStore){
        this.store = inMemoryStore;
    }

    @Get
    public List<Product> getAllProducts() {
        return new ArrayList<>(store.getProducts().values());
    }

    @Get("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return store.getProducts().get(id);
    }

    @Get("filter{?max,offset}")
    public List<Product> getProductsByFilter(
            @QueryValue Optional<Integer> max,
            @QueryValue Optional<Integer> offset
    ){
        return this.store.getProducts().
                values().
                stream().
                skip(offset.orElse(0)).
                limit(max.orElse(5)).
                toList();
    }
}
