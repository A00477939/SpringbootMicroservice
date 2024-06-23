package com.microservice.fraud.customer.Service;

import com.microservice.fraud.customer.Entity.CustomerRegistrationRequest;
import com.microservice.fraud.customer.Entity.Customer;
import com.microservice.fraud.customer.FraudCheckResponse;
import com.microservice.fraud.customer.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //To save the customer in database
        customerRepository.saveAndFlush(customer);


        //Check if fraud
        String fraudCheckUrl = "http://localhost:8081/api/v1/fraud_check/{customerId}";
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                fraudCheckUrl,
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse != null && fraudCheckResponse.isFraud()) {
            throw new IllegalArgumentException("No allowed");
        }




    }
}
