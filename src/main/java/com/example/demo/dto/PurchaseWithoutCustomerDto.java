package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PurchaseWithoutCustomerDto   {
  private BigInteger id;
  private ItemDto item;
  private long amount;
}
