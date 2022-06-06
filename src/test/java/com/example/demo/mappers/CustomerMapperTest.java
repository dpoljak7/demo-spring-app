package com.example.demo.mappers;

import com.example.demo.TestBase;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;


class CustomerMapperTest extends TestBase {

  @Autowired
  private CustomerMapper customerMapper;

  @Test
  void should_map_to_customerDto() {
    //given
    Customer customer = new Customer("firstName1", "lastName1");
    customer.setId(BigInteger.ONE);

    //when
    CustomerDto customerDto = customerMapper.from(customer);

    //then
    Assertions.assertThat(customer.getId()).isEqualTo(customerDto.getId());
    Assertions.assertThat(customer.getFirstName()).isEqualTo(customerDto.getFirstName());
    Assertions.assertThat(customer.getLastName()).isEqualTo(customerDto.getLastName());

  }

}