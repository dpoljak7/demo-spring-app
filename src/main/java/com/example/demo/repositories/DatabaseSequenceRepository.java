package com.example.demo.repositories;

import com.example.demo.model.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, BigInteger> {

}
