package com.example.demo.model.listener;

import com.example.demo.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ItemModelListener extends AbstractMongoEventListener<Item> {

  private final SequenceGeneratorService sequenceGeneratorService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Item> event) {
    if (Objects.isNull(event.getSource().getId())) {
      event.getSource().setId(sequenceGeneratorService.generateSequence(Item.SEQUENCE_NAME));
    }
  }
}
