package com.microservice.fraud.customer.Controller;

import com.microservice.fraud.customer.Entity.CustomerRegistrationRequest;
import com.microservice.fraud.customer.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Registering new Customer{}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
