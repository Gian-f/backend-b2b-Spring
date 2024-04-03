package com.br.b2b.service.store;

import com.br.b2b.dto.response.CategoryResponse;
import com.br.b2b.dto.response.ProductResponse;

public interface StoreService {
    ProductResponse getAllProducts();
    CategoryResponse getAllCategories();
}
