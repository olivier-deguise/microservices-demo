package com.org.myapp.demo.fraud;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class FraudConfig {

    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder()
                .group("fraud")
                .pathsToMatch("/api/v1/fraud/**")
                .build();
    }
}
