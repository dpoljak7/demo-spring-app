package com.example.demo.mappers;

import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.dto.PurchaseWithoutCustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

  @Mapping(target = "id", source = "purchase.id")
  @Mapping(target = "amount", source = "purchase.amount")
  PurchaseAllDataDto from(Purchase purchase, Customer customer, Item item);

  @Mapping(target = "id", source = "purchase.id")
  @Mapping(target = "amount", source = "purchase.amount")
  PurchaseWithoutCustomerDto from(Purchase purchase, Item item);
}
