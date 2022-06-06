package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PurchaseAllDataDto {
  private BigInteger id;
  private CustomerDto customer;
  private ItemDto item;
  private long amount;
}
