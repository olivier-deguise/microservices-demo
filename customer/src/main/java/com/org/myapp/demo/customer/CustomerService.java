package com.org.myapp.demo.customer;

import com.org.myapp.demo.amqp.RabbitMQMessageProducer;
import com.org.myapp.demo.clients.fraud.FraudCheckResponse;
import com.org.myapp.demo.clients.fraud.FraudClient;
import com.org.myapp.demo.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email is valid
        //todo: check if email not taken

        customerRepository.saveAndFlush(customer);

        //check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster!");
        }
        //todo: make it async i.e. add to queue
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...", customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
