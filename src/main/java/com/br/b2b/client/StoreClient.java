package com.br.b2b.client;

import com.br.b2b.model.Category;
import com.br.b2b.model.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "store-client", url = "https://api.escuelajs.co/api/v1")
public interface StoreClient {

    @GetMapping("/products")
    List<Product> getAllProducts();

    @GetMapping("/categories")
    List<Category> getAllCategories();
}