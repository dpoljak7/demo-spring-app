package com.example.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ItemDto {
  private BigInteger id;
  private String description;
}
