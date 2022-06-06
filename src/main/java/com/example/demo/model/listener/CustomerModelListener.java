package com.example.demo.model.listener;

import com.example.demo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomerModelListener extends AbstractMongoEventListener<Customer> {

  private final SequenceGeneratorService sequenceGeneratorService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
    if (Objects.isNull(event.getSource().getId())) {
      event.getSource().setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
    }
  }
}
