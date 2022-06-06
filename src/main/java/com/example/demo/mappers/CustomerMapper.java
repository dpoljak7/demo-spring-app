package com.example.demo.mappers;

import com.example.demo.dto.CustomerAllDataDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PurchaseWithoutCustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = ItemMapper.class)
public interface CustomerMapper {

  CustomerDto from(Customer customer);

  @Mapping(target = "id", source = "customer.id")
  @Mapping(target = "firstName", source = "customer.firstName")
  @Mapping(target = "lastName", source = "customer.lastName")
  CustomerAllDataDto from(Customer customer, List<PurchaseWithoutCustomerDto> purchases);

}