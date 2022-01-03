package com.org.myapp.demo.apigw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ApiGWApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiGWApplication.class, args);
    }

}
