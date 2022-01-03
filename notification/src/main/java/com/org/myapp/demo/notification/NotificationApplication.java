package com.org.myapp.demo.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(scanBasePackages = {"com.org.myapp.demo.notification", "com.org.myapp.demo.amqp"})
//@EnableEurekaClient
@EnableDiscoveryClient
@PropertySources(@PropertySource("classpath:clients-${spring.profiles.active}.properties"))
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
//        return args -> {
//            producer.publish("foo", notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}