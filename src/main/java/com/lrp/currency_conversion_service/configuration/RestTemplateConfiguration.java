package com.lrp.currency_conversion_service.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 proxyBeanMethods

 true (default): Ensures SINGLETON beans by intercepting method calls, suitable for interdependent beans.
 Usecases:
 When your @Bean methods depend on each other and you need to ensure singleton semantics.

 When you have inter-bean dependencies within the same configuration class that require method interception to maintain consistency.

 --------------------------------------------------------------------------
 false: Disables proxying for better performance when beans are independent.
 means it will execute method directly, potentially creating new instances.
 Calls are not intercepted.

 Usecases:
 When your @Bean methods are independent and do not call each other.
 When aiming for improved performance and reduced memory footprint in your application.
    coz it reduces the overhead associated with proxy creation and method interception.
 In scenarios where configuration classes are purely for bean definitions without interdependencies.
 */
@Configuration (proxyBeanMethods = false)
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced //had impact if we use localhost:8080 now
    RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
