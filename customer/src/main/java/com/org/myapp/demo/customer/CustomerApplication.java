package com.org.myapp.demo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.org.myapp.demo.customer", "com.org.myapp.demo.amqp"})
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableFeignClients(basePackages="com.org.myapp.demo.clients")
@EnableSwagger2
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
