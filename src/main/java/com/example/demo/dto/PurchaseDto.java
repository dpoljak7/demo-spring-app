package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PurchaseDto {
  private BigInteger id;
  private BigInteger customerId;
  private BigInteger itemId;
  private long amount;
}
