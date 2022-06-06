package com.example.demo.controller;

import com.example.demo.IntegrationTestBase;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Purchase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

class CustomerControllerTest extends IntegrationTestBase {

  @Test
  void should_find_saved_customer() throws Exception {
    //given
    Item item1 = new Item("item1");
    item1 = itemRepository.save(item1);
    Item item2 = new Item("item2");
    item2 = itemRepository.save(item2);
    Customer customer = new Customer("firstNameTest", "lastNameTest");
    customer = customerRepository.save(customer);

    Purchase purchase1 = new Purchase(customer.getId(), item1.getId(), 2);
    purchaseRepository.save(purchase1);

    //when
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/{id}", customer.getId()));

    //then
    MvcResult mvcResult = resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();
    Customer customerReturned = objectMapper.readValue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), Customer.class);
    Assertions.assertThat(customerReturned.getFirstName()).isEqualTo(customer.getFirstName());
    Assertions.assertThat(customerReturned.getId()).isEqualTo(customer.getId());
  }

}