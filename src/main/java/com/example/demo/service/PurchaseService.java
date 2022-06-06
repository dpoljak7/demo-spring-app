package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.mappers.PurchaseMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseService {

  private final ItemRepository itemRepository;
  private final PurchaseRepository purchaseRepository;
  private final CustomerRepository customerRepository;
  private final PurchaseMapper purchaseMapper;

  public List<PurchaseAllDataDto> filterByItemDescription(String description, Pageable pageable) {
    Optional<Item> itemOptional = itemRepository.findByDescription(description);
    if (itemOptional.isEmpty()) {
      log.debug("No item found for description={}", description);
      return new ArrayList<>();
    }
    Item item = itemOptional.get();
    List<Purchase> purchases = purchaseRepository.findAllByItemId(item.getId(), pageable);

    List<PurchaseAllDataDto> purchaseAllDataDtos = mapPurchases(item, purchases);
    return purchaseAllDataDtos;
  }

  private List<PurchaseAllDataDto> mapPurchases(Item item, List<Purchase> purchases) {
    List<PurchaseAllDataDto> purchaseAllDataDtos = new ArrayList<>();
    for (Purchase purchase : purchases) {
      Optional<Customer> customerOptional = customerRepository.findById(purchase.getCustomerId());
      Customer customer = customerOptional.get();
      PurchaseAllDataDto purchaseAllDataDto = purchaseMapper.from(purchase, customer, item);
      purchaseAllDataDtos.add(purchaseAllDataDto);
    }
    return purchaseAllDataDtos;
  }

}
