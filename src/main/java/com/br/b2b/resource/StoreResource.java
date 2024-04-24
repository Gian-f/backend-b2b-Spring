package com.br.b2b.resource;

import com.br.b2b.dto.response.CategoryResponse;
import com.br.b2b.dto.response.ProductResponse;
import com.br.b2b.service.store.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/store")
public class StoreResource {

    @Autowired
    private StoreServiceImpl storeService;

    @GetMapping("/products")
    public ResponseEntity<ProductResponse> getAllProducts() {
        return ResponseEntity.ok(storeService.getAllProducts());
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        return ResponseEntity.ok(storeService.getAllCategories());
    }
}
