package com.example.demo.model.listener;

import com.example.demo.model.DatabaseSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {

  private final MongoOperations mongoOperations;
  public BigInteger generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                                                             new Update().inc("seq", 1),
                                                             options().returnNew(true).upsert(true),
                                                             DatabaseSequence.class);
    return !Objects.isNull(counter) ? BigInteger.valueOf(counter.getSeq()) : BigInteger.ONE;
  }
}
