package com.microservice.fraud.customer.Entity;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
