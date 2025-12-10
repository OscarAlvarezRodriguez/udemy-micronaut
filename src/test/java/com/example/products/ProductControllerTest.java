package com.example.products;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class ProductControllerTest {

    @Inject
    @Client("/products")
    private HttpClient httpClient;

    @Test
    void testGetAllProducts() {
        JsonNode response = httpClient.toBlocking().retrieve("/", JsonNode.class);
        assertEquals(0, String.valueOf(response).indexOf("\"id\":0"));
    }

    @Test
    void testGetProductById() {
        Product response = httpClient.toBlocking().retrieve("/0", Product.class);
        assertEquals(0, response.id());
    }
}
