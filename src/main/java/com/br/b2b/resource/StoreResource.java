package com.br.b2b.resource;

import com.br.b2b.dto.response.StoreResponse;
import com.br.b2b.model.Category;
import com.br.b2b.model.Product;
import com.br.b2b.service.store.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class StoreResource {
    private final StoreService storeService;

    public StoreResource(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/products")
    public Mono<StoreResponse> getAllProducts() {
        return storeService.getAllProducts();
    }

    @GetMapping("/categories")
    public Mono<StoreResponse> getAllCategories() {
        return storeService.getAllCategories();
    }
}
