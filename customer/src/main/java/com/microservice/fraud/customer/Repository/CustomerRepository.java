package com.microservice.fraud.customer.Repository;

import com.microservice.fraud.customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
