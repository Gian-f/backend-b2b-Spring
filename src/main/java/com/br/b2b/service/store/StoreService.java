package com.br.b2b.service.store;

import com.br.b2b.dto.response.StoreResponse;
import reactor.core.publisher.Mono;

public interface StoreService {
    Mono<StoreResponse> getAllProducts();
    Mono<StoreResponse> getAllCategories();
}
