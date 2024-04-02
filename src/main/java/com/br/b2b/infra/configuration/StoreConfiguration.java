package com.br.b2b.infra.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class StoreConfiguration {

    @Value("${store.base-url}")
    public String storeBaseUrl;

    @Value("${store.products}")
    public String storeProducts;

    @Value("${store.categories}")
    public String storeCategories;
}