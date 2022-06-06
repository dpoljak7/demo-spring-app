package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;

@Document(collection = "item")
public class Item {
  @JsonIgnore

  @Transient
  public static final String SEQUENCE_NAME = "item_sequence";

  @Id
  private BigInteger id;
  private String description;

  public Item() {
  }

  public Item(String description) {
    this.description = description;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
