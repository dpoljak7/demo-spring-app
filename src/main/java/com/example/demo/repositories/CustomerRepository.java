package com.example.demo.repositories;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, BigInteger> {

  List<Customer> findAllByFirstName(String firstName);
}