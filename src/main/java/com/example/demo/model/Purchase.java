package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;

@Document(collection = "purchase")
public class Purchase {
  @JsonIgnore

  @Transient
  public static final String SEQUENCE_NAME = "purchase_sequence";

  @Id
  private BigInteger id;
  private BigInteger customerId;
  private BigInteger itemId;
  private long amount;


  public Purchase() {
  }

  public Purchase(BigInteger customerId, BigInteger itemId, long amount) {
    this.customerId = customerId;
    this.itemId = itemId;
    this.amount = amount;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public BigInteger getCustomerId() {
    return customerId;
  }

  public void setCustomerId(BigInteger customerId) {
    this.customerId = customerId;
  }

  public BigInteger getItemId() {
    return itemId;
  }

  public void setItemId(BigInteger itemId) {
    this.itemId = itemId;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

}
