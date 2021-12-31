package com.org.myapp.demo.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


//@FeignClient("notification") //Avec Eureka server
@FeignClient(name="notification", url="${clients.notification.url}") //avec k8s
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
