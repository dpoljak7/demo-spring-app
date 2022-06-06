package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CustomerDto {
  private BigInteger id;
  private String firstName;
  private String lastName;
}
