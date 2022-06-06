package com.example.demo.repositories;

import com.example.demo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item, BigInteger> {

  Optional<Item> findByDescription(String description);
}
