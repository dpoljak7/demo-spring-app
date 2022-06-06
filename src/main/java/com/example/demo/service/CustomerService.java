package com.example.demo.service;

import com.example.demo.dto.CustomerAllDataDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.dto.PurchaseWithoutCustomerDto;
import com.example.demo.mappers.CustomerMapper;
import com.example.demo.mappers.PurchaseMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

  private final CustomerMapper customerMapper;
  private final PurchaseMapper purchaseMapper;

  private final CustomerRepository customerRepository;
  private final PurchaseRepository purchaseRepository;
  private final ItemRepository itemRepository;
  public CustomerDto findById(BigInteger id) {
    Optional<Customer> customerOptional = customerRepository.findById(id);
    if (customerOptional.isPresent()) {
      Customer customer = customerOptional.get();
      CustomerDto customerDto = customerMapper.from(customer);
      return customerDto;
    } else {
      throw new IllegalArgumentException("Customer with id is not present, id=" + id);
    }
  }

  public List<CustomerAllDataDto> filterByFirstName(String firstName) {
    List<Customer> customers = customerRepository.findAllByFirstName(firstName);
    List<CustomerAllDataDto> customerAllDataDtos = new ArrayList<>();
    for (Customer customer : customers) {
      List<PurchaseWithoutCustomerDto> purchases = findPurchases(customer);
      CustomerAllDataDto customerAllDataDto = customerMapper.from(customer, purchases);
      customerAllDataDtos.add(customerAllDataDto);
    }
    return customerAllDataDtos;
  }

  private List<PurchaseWithoutCustomerDto> findPurchases(Customer customer) {
    List<Purchase> purchases = purchaseRepository.findAllByCustomerId(customer.getId());
    List<PurchaseWithoutCustomerDto> purchasesMapped = new ArrayList<>();
    for (Purchase purchase : purchases) {
      Item item = itemRepository.findById(purchase.getItemId()).get();
      PurchaseWithoutCustomerDto purchaseWithoutCustomerDto = purchaseMapper.from(purchase, item);
      purchasesMapped.add(purchaseWithoutCustomerDto);
    }
    log.debug("Found purchases for customerId={}, numberOfPurchases={}", customer.getId(), purchasesMapped.size());
    return purchasesMapped;
  }

}
