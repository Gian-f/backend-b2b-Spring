package com.br.b2b.service.store;

import com.br.b2b.dto.response.CategoryResponse;
import com.br.b2b.dto.response.ProductResponse;
import com.br.b2b.model.Category;
import com.br.b2b.model.Product;
import com.br.b2b.repository.CategoryRepository;
import com.br.b2b.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public StoreServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    @Cacheable(value = "productsCache")
    public ProductResponse getAllProducts() {
        ProductResponse response = new ProductResponse();
        try {
            List<Product> products = productRepository.findAll();
            response.setMessage("Operação realizada com sucesso!");
            response.setResult(products);
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Ocorreu um erro ao tentar buscar produtos: " + e.getMessage());
            response.setResult(Collections.emptyList());
            response.setStatus(false);
        }
        return response;
    }

    @Override
    @Cacheable("categoriesCache")
    public CategoryResponse getAllCategories() {
        CategoryResponse response = new CategoryResponse();
        try {
            List<Category> categories = categoryRepository.findAll();
            response.setMessage("Operação realizada com sucesso!");
            response.setResult(categories);
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Ocorreu um erro ao tentar buscar categorias: " + e.getMessage());
            response.setResult(Collections.emptyList());
            response.setStatus(false);
        }
        return response;
    }
}
