package com.org.myapp.demo.customer;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder()
                .group("customer")
                .pathsToMatch("/api/v1/customers/**")
                .build();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
