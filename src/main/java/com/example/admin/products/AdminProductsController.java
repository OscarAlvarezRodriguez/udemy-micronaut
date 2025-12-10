package com.example.admin.products;

import com.example.data.InMemoryStore;
import com.example.products.Product;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;

@Controller("/admin/products")
public class AdminProductsController {

    private final InMemoryStore store;

    public AdminProductsController(InMemoryStore store) {
        this.store = store;
    }


    @Post
    @Status(HttpStatus.CREATED)
    public Product AddNewProduct(@Body Product product){
        if (this.store.getProducts().containsKey(product.id())){
            throw new HttpStatusException(
                    HttpStatus.CONFLICT, "Product with ID " + product.id() + " already exists."
            );
        }
        return this.store.addProduct(product);
    }

    @Put("/{id}")
    public Product UpdateProduct(@PathVariable Integer id, @Body Product product){
        if (!this.store.getProducts().containsKey(id)){
            throw new HttpStatusException(
                    HttpStatus.NOT_FOUND, "Product with ID " + product.id() + " not found."
            );
        }

        Product existingProduct = new Product(
                id,
                product.name(),
                product.type()
        );

        return this.store.addProduct(existingProduct);
    }
}
