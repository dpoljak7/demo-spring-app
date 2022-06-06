package com.example.demo.utils;

import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataGenerator {

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private PurchaseRepository purchaseRepository;


  public void generateDataInDatabase(int numberOfPurchases, int numberOfCustomers, int numberOfItems) {
    List<Customer> customerList = generateCustomers(numberOfCustomers);
    List<Item> itemList = generateItems(numberOfItems);

    for (int i = 0; i < numberOfPurchases; i++) {
      Purchase purchase = new Purchase();
      purchase.setAmount(i + 1);
      int j = i % numberOfCustomers;
      purchase.setCustomerId(customerList.get(j).getId());
      int k = i % numberOfItems;
      purchase.setItemId(itemList.get(k).getId());
      purchaseRepository.save(purchase);
    }
  }

  private List<Item> generateItems(int numberOfItems) {
    List<Item> items = new ArrayList<>();
    for (int i = 0; i < numberOfItems; i++) {
      Item item = new Item("item" + i);
      item = itemRepository.save(item);
      items.add(item);
    }
    return items;
  }

  private List<Customer> generateCustomers(int numberOfCustomers) {
    List<Customer> customers = new ArrayList<>();
    for (int i = 0; i < numberOfCustomers; i++) {
      Customer customer = new Customer("firstName" + i, "lastName" + i);
      customer = customerRepository.save(customer);
      customers.add(customer);
    }
    return customers;
  }

}
