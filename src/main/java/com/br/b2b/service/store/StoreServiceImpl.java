package com.br.b2b.service.store;

import com.br.b2b.dto.response.StoreResponse;
import com.br.b2b.infra.configuration.StoreConfiguration;
import com.br.b2b.model.Category;
import com.br.b2b.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

public class StoreServiceImpl implements StoreService {

    private final WebClient webClient;
    private final String productsUrl;
    private final String categoriesUrl;

    public StoreServiceImpl(WebClient webClient, StoreConfiguration storeConfiguration) {
        this.webClient = webClient;
        this.productsUrl = storeConfiguration.storeBaseUrl + storeConfiguration.storeProducts;
        this.categoriesUrl = storeConfiguration.storeBaseUrl + storeConfiguration.storeCategories;
    }

    @Override
    public Mono<StoreResponse> getAllProducts() {
        return webClient.get()
                .uri(productsUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {})
                .map(products -> {
                    StoreResponse response = new StoreResponse();
                    response.setMessage("Operação realizada com sucesso!");
                    response.setResult(products);
                    response.setStatus(true);
                    return response;
                });
    }

    @Override
    public Mono<StoreResponse> getAllCategories() {
        return webClient.get()
                .uri(categoriesUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Category>>() {})
                .map(categories -> {
                    StoreResponse response = new StoreResponse();
                    response.setMessage("Operação realizada com sucesso!");
                    response.setResult(categories);
                    response.setStatus(true);
                    return response;
                });
    }
}
