package com.example.demo.service;

import com.example.demo.IntegrationTestBase;
import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

class PurchaseServiceTest extends IntegrationTestBase {

  @Autowired
  private PurchaseService purchaseService;

  @Test
  void should_filter_purchases_by_item_description() {
    //given
    Item item1 = new Item("item1");
    item1 = itemRepository.save(item1);
    Item item2 = new Item("item2");
    item2 = itemRepository.save(item2);
    Customer customer1 = new Customer("firstName1", "lastName1");
    customer1 = customerRepository.save(customer1);
    Customer customer2 = new Customer("firstName2", "lastName2");
    customer2 = customerRepository.save(customer2);

    Purchase purchase1 = new Purchase(customer1.getId(), item1.getId(), 2);
    purchaseRepository.save(purchase1);
    Purchase purchase2 = new Purchase(customer2.getId(), item2.getId(), 3);
    purchaseRepository.save(purchase2);

    String description = item1.getDescription();

    //when
    List<PurchaseAllDataDto> purchaseAllDataDtos = purchaseService.filterByItemDescription(description, PageRequest.of(0, 1));

    //then
    Assertions.assertThat(purchaseAllDataDtos.size()).isEqualTo(1);
    PurchaseAllDataDto purchase = purchaseAllDataDtos.get(0);
    Assertions.assertThat(purchase.getCustomer().getId()).isEqualTo(customer1.getId());
    Assertions.assertThat(purchase.getItem().getId()).isEqualTo(item1.getId());
    Assertions.assertThat(purchase.getAmount()).isEqualTo(purchase1.getAmount());
  }

}