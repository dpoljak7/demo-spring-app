package com.example.demo.controller;

import com.example.demo.dto.CustomerAllDataDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{id}")
  public CustomerDto getCustomer(@PathVariable("id") BigInteger id) {
    return customerService.findById(id);
  }

  @GetMapping("filter-by-firstName/{firstName}")
  public List<CustomerAllDataDto> filter(@PathVariable("firstName") String firstName) {
    List<CustomerAllDataDto> customerAllDataDtos = customerService.filterByFirstName(firstName);
    log.debug("Response={}", customerAllDataDtos);
    return customerAllDataDtos;
  }
}
