package com.lrp.currency_conversion_service.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//TODO, if I won't put it sa Configuration, what is the diff
//other advantage of using this approach too? aside from micrometer only?
// //What does proxyBeanMethods mean?

@Configuration (proxyBeanMethods = false)
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
