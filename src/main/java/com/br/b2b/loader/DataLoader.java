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

                //Moda
                products.add(new Product(1L, "Jaqueta de Couro Estilo Motociclista", 299.99, "Jaqueta de couro com estilo motociclista.", modaCategory, Collections.singletonList("https://i.ibb.co/0hXWpfn/Chaqueta-de-Cuero-Estilo-Motociclista.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(2L, "Tênis Adidas Ultraboost", 199.99, "Tênis esportivo da marca Adidas, modelo Ultraboost.", modaCategory, Collections.singletonList("https://i.ibb.co/7jKp0rs/Zapatillas-Adidas-Ultraboost.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(3L, "Calça Jeans Levi's 501 Original", 149.99, "Calça jeans clássica da marca Levi's, modelo 501 Original.", modaCategory, Collections.singletonList("https://i.ibb.co/yn9tWB2/Jeans-Levi-s-501-Original.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(4L, "Vestido Elegante de Noite", 129.99, "Vestido elegante para eventos noturnos.", modaCategory, Collections.singletonList("https://i.ibb.co/WVY7wyD/Vestido-Elegante-de-Noche.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(5L, "Camiseta Nike Dri-FIT", 39.99, "Camiseta esportiva da marca Nike, tecnologia Dri-FIT para absorção de suor.", modaCategory, Collections.singletonList("https://i.ibb.co/Hpv1gLk/Camiseta-Nike-Dri-FIT.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));

                //Eletrônicos
                products.add(new Product(6L, "Fones de Ouvido sem Fio Bose Quiet Comfort 35", 349.99, "Fones de ouvido sem fio da marca Bose, modelo Quiet Comfort 35.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/YTb1Ybv/Auriculares-Inal-mbricos-Bose-Quiet-Comfort-35.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(7L, "Console Play Station 5", 4499.99, "Console de videogame da Sony, modelo Play Station 5.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/BcqzzgF/Consola-Play-Station-5.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(8L, "Câmera Sony Alpha A7 III", 1299.99, "Câmera fotográfica da Sony, modelo Alpha A7 III.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/ZHT2r1s/C-mara-Sony-Alpha-A7-III.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(9L, "Smartphone Samsung Galaxy S21", 1799.99, "Smartphone da Samsung, modelo Galaxy S21.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/mXkVjdS/Smartphone-Samsung-Galaxy-S21.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(10L, "Apple Mac Book Pro", 8999.99, "Notebook da Apple, modelo Mac Book Pro.", eletronicosCategory, Collections.singletonList("https://i.ibb.co/cDj3dpX/Apple-Mac-Book-Pro.png"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));

                //Saúde e Beleza
                products.add(new Product(11L, "La Roche-Posay Effaclar Sérum Ultra Concentrado", 174.72, "Eficácia clinicamente comprovada com resultados visíveis: -45% Espinhas; -49% Marcas de Acne;", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/51za6kC9k1L._AC_SX679_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(12L, "Vichy Mineral 89 Sérum Concentrado Hidratante", 139.90, "Hidrata e fortalece a pele com ácido hialurônico de origem natural e Água Termal Mineralizante de Vichy. Ideal para todos os tipos de pele, inclusive as sensíveis.", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/51uM+yRQcJL._AC_SX342_SY445_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(13L, "Cetaphil Gentle Skin Cleanser", 59.90, "Limpador facial suave e não comedogênico, ideal para peles sensíveis e secas. Remove impurezas sem agredir a pele.", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/71xY1eaDeKL._SX466_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(14L, "Nivea Creme", 34.90, "Creme hidratante clássico para o rosto e corpo. Hidrata profundamente e protege a pele por até 24 horas.", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/51U+ULwABqL._AC_SY300_SX300_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(15L, "Bepantol Derma Pomada", 29.90, "Pomada reparadora para peles secas, rachadas e irritadas. Promove a cicatrização e hidrata profundamente.", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/41AKkxml0kL._AC_SX679_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(16L, "Eucerin Hyaluron-Filler Creme para Olhos", 119.90, "Creme anti-rugas para a área dos olhos com ácido hialurônico e vitamina B5. Preenche rugas, reduz olheiras e bolsas.", saudeEbelezaCategory, Collections.singletonList("https://m.media-amazon.com/images/I/71iDL2frZYL._AC_SX679_.jpg"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));

                //Alimentação
                products.add(new Product(17L, "Leite Integral", 5.99, "Leite integral pasteurizado.", alimentacaoCategory, Collections.singletonList("https://img.freepik.com/fotos-premium/leite-de-aveia-na-garrafa-de-vidro-na-madeira-rustica_271740-2553.jpg?w=740"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(18L, "Pão de Forma Integral", 3.49, "Pão de forma integral com 8 grãos.", alimentacaoCategory, Collections.singletonList("https://img.freepik.com/fotos-premium/fatias-de-pao-na-placa-de-madeira_23-2148359137.jpg?w=1380"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(19L, "Granola com Castanhas e Frutas Secas", 12.99, "Granola crocante com castanhas e frutas secas.", alimentacaoCategory, Collections.singletonList("https://img.freepik.com/fotos-gratis/sortido-de-comida-infantil-saboroso-alto-angulo_23-2149627800.jpg?t=st=1715186244~exp=1715189844~hmac=a4cff449d412a033beee8ce52e492fbfdf99f9dc452d50ba1a768127c750cf51&w=740"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(20L, "Maçã Fuji", 2.99, "Maçã Fuji fresca e crocante.", alimentacaoCategory, Collections.singletonList("https://img.freepik.com/fotos-gratis/maca-vermelha-com-a-folha-verde-no-fundo-branco_1232-3290.jpg?t=st=1715186301~exp=1715189901~hmac=6104a113f8b88f15749bbffe04ce771247b85c60d243511477da6f5816d84b67&w=1380"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(21L, "Iogurte Natural Integral", 4.50, "Iogurte natural integral sem adição de açúcares.", alimentacaoCategory, Collections.singletonList("https://img.freepik.com/fotos-premium/delicioso-iogurte-com-mirtilos-e-morangos-close-up_122799-127.jpg?w=740"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));

                //CasaEjardim
                products.add(new Product(22L, "Jogo de Cama Queen Size", 199.99, "Jogo de cama Queen Size em algodão 100%.", casaEJardimCategory, Collections.singletonList("https://img.freepik.com/fotos-gratis/arranjo-de-cama-aconchegante-de-alto-angulo_23-2150326152.jpg?t=st=1715186398~exp=1715189998~hmac=bf28ac0d9ca9fb025b5193062d2d90d497df0e0bc0f53c631d714bbcfaebef55&w=740"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(23L, "Conjunto de Sofá e Poltrona", 1299.99, "Conjunto de sofá e poltrona em couro sintético.", casaEJardimCategory, Collections.singletonList("https://img.freepik.com/fotos-gratis/travesseiro-no-interior-da-decoracao-do-sofa-da-sala-de-estar_74190-12625.jpg?t=st=1715186465~exp=1715190065~hmac=dd58bf4800dc211ee7e10aca9c8a956e1b5142bbc804af9c81b8f02806639dbb&w=1380"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(24L, "Churrasqueira Elétrica", 249.99, "Churrasqueira elétrica portátil com grelha antiaderente.", casaEJardimCategory, Collections.singletonList("https://img.freepik.com/fotos-gratis/homem-grelhando-carne-linguicas-ao-ar-livre_53876-63336.jpg?t=st=1715186714~exp=1715190314~hmac=c1a36dc6fa4b80d1f27923ab1853e19d27cacf5eb2596820cfd90f31bcb0e37f&w=1060"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(25L, "Kit de Ferramentas para Jardim", 99.99, "Kit de ferramentas para jardinagem com 10 peças.", casaEJardimCategory, Collections.singletonList("https://img.freepik.com/fotos-premium/vista-de-alto-angulo-de-varias-flores-na-mesa_1048944-9273677.jpg?w=1380"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
                products.add(new Product(26L, "Luminária de Mesa Decorativa", 59.99, "Luminária de mesa decorativa com abajur de tecido.", casaEJardimCategory, Collections.singletonList("https://img.freepik.com/fotos-premium/lampada-elegante-na-mesa-contra-um-fundo-claro_917213-38000.jpg?w=826"), LocalDateTime.now().toString(), LocalDateTime.now().toString()));
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