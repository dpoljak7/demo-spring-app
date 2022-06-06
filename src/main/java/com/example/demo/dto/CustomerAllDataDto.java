package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class CustomerAllDataDto {
  private BigInteger id;
  private String firstName;
  private String lastName;
  private List<PurchaseWithoutCustomerDto> purchases;
}
