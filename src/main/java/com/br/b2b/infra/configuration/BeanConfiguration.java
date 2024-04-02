package com.br.b2b.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

    private String storeUrl;

    public BeanConfiguration(StoreConfiguration storeConfiguration){
        this.storeUrl = storeConfiguration.storeBaseUrl;
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(storeUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
