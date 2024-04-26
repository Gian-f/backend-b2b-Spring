package com.br.b2b.loader;

import com.br.b2b.model.Category;
import com.br.b2b.model.Product;
import com.br.b2b.repository.CategoryRepository;
import com.br.b2b.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = createCategories();
        categoryRepository.saveAll(categories);

        List<Product> products = createProducts(categories);
        productRepository.saveAll(products);
    }

    private List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();
        List<Category> existingCategories = categoryRepository.findAll();

        if (existingCategories.isEmpty()) {
            categories.add(new Category(1L, "Eletrônicos", "https://i.ibb.co/1QzkGf7/Electronica.png", LocalDateTime.now().toString(), LocalDateTime.now().toString()));
            categories.add(new Category(2L, "Moda", "https://i.ibb.co/Chjv3k8/Moda.png", LocalDateTime.now().toString(), LocalDateTime.now().toString()));
            categories.add(new Category(3L, "Alimentação", "https://i.ibb.co/hLpVpZX/Alimentaci-n.png", LocalDateTime.now().toString(), LocalDateTime.now().toString()));
            categories.add(new Category(4L, "Casa e Jardim", "https://i.ibb.co/s2GpH7J/Hogar-y-jardin.png", LocalDateTime.now().toString(), LocalDateTime.now().toString()));
            categories.add(new Category(5L, "Saúde e Beleza", "https://i.ibb.co/ZSsFGNL/Salud-y-belleza.png", LocalDateTime.now().toString(), LocalDateTime.now().toString()));
        }

        return categories;
    }

    private List<Product> createProducts(List<Category> categories) {
        List<Product> products = new ArrayList<>();

        List<Product> existingProducts = productRepository.findAll();

        if (existingProducts.isEmpty()) {
            Category eletronicosCategory = findCategoryByName(categories, "Eletrônicos");
            Category modaCategory = findCategoryByName(categories, "Moda");
            Category alimentacaoCategory = findCategoryByName(categories, "Alimentação");
            Category casaEJardimCategory = findCategoryByName(categories, "Casa e Jardim");
            Category saudeEbelezaCategory = findCategoryByName(categories, "Saúde e Beleza");

            if (modaCategory != null && eletronicosCategory != null && alimentacaoCategory != null && casaEJardimCategory != null && saudeEbelezaCategory != null) {
                products.add(new Product(1L, "Jaqueta de Couro Estilo Motociclista", 299.99, "Jaqueta de couro com estilo motociclista.", modaCategory, Collections.singletonList("https://i.ibb.co/0hXWpfn/Chaqueta-de-Cuero-Estilo-Motociclista.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(2L, "Tênis Adidas Ultraboost", 199.99, "Tênis esportivo da marca Adidas, modelo Ultraboost.", modaCategory, Collections.singletonList("https://i.ibb.co/7jKp0rs/Zapatillas-Adidas-Ultraboost.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(3L, "Calça Jeans Levi's 501 Original", 149.99, "Calça jeans clássica da marca Levi's, modelo 501 Original.", modaCategory, Collections.singletonList("https://i.ibb.co/yn9tWB2/Jeans-Levi-s-501-Original.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(4L, "Vestido Elegante de Noite", 129.99, "Vestido elegante para eventos noturnos.", modaCategory, Collections.singletonList("https://i.ibb.co/WVY7wyD/Vestido-Elegante-de-Noche.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(5L, "Camiseta Nike Dri-FIT", 39.99, "Camiseta esportiva da marca Nike, tecnologia Dri-FIT para absorção de suor.", modaCategory, Collections.singletonList("https://i.ibb.co/Hpv1gLk/Camiseta-Nike-Dri-FIT.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(6L, "Fones de Ouvido sem Fio Bose Quiet Comfort 35", 349.99, "Fones de ouvido sem fio da marca Bose, modelo Quiet Comfort 35.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/YTb1Ybv/Auriculares-Inal-mbricos-Bose-Quiet-Comfort-35.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(7L, "Console Play Station 5", 4499.99, "Console de videogame da Sony, modelo Play Station 5.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/BcqzzgF/Consola-Play-Station-5.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(8L, "Câmera Sony Alpha A7 III", 1299.99, "Câmera fotográfica da Sony, modelo Alpha A7 III.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/ZHT2r1s/C-mara-Sony-Alpha-A7-III.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(9L, "Smartphone Samsung Galaxy S21", 1799.99, "Smartphone da Samsung, modelo Galaxy S21.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/mXkVjdS/Smartphone-Samsung-Galaxy-S21.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(10L, "Apple Mac Book Pro", 8999.99, "Notebook da Apple, modelo Mac Book Pro.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/cDj3dpX/Apple-Mac-Book-Pro.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
            }
        }

        return products;
    }

    private Category findCategoryByName(List<Category> categories, String categoryName) {
        return categories.stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst()
                .orElse(null);
    }
}