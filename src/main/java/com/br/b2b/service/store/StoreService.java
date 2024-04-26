package com.br.b2b.service.store;

import com.br.b2b.dto.response.CategoryResponse;
import com.br.b2b.dto.response.FindProductResponse;
import com.br.b2b.dto.response.ProductResponse;
import com.br.b2b.repository.ProductRepository;

public interface StoreService {
    ProductResponse getAllProducts();
    CategoryResponse getAllCategories();
    FindProductResponse findProductById(Long id);
}
