package com.org.myapp.demo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"com.org.myapp.demo.customer", "com.org.myapp.demo.amqp"})
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.org.myapp.demo.clients")
@PropertySources(@PropertySource("classpath:clients-${spring.profiles.active}.properties"))
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
