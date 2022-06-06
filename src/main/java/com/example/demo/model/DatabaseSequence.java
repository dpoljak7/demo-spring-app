package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "database_sequences")
@Data
@Builder
public class DatabaseSequence {

  @Id
  private String id;
  private long seq;
}