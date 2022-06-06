package com.example.demo.mappers;

import com.example.demo.dto.ItemDto;
import com.example.demo.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  ItemDto from(Item item);
}
