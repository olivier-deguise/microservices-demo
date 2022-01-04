package com.org.myapp.demo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.org.myapp.demo.customer", "com.org.myapp.demo.amqp"})
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableFeignClients(basePackages="com.org.myapp.demo.clients")
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
