package com.example.demo.repositories;

import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface PurchaseRepository extends MongoRepository<Purchase, BigInteger> {

  List<Purchase> findAllByItemId(BigInteger itemId, Pageable pageable);
  List<Purchase> findAllByCustomerId(BigInteger customerId);
}
