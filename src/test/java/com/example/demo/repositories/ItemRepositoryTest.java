package com.example.demo.repositories;

import com.example.demo.IntegrationTestBase;
import com.example.demo.model.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class ItemRepositoryTest extends IntegrationTestBase {

  @Test
  void should_return_item_by_description() {
    //given
    String description = "item1";
    Item item = new Item(description);
    itemRepository.save(item);
    //when
    Optional<Item> itemOptional = itemRepository.findByDescription(description);

    //then
    Assertions.assertThat(itemOptional.isPresent()).isTrue();
  }

}