package com.example.demo;

import com.example.demo.config.IntegrationTestConfig;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.DatabaseSequenceRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.PurchaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
@TestPropertySource(locations = { "classpath:application.properties"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTestBase {

  //define mocks if required
  @Autowired
  private WebApplicationContext webApplicationContext;
  @Autowired
  private DatabaseSequenceRepository databaseSequenceRepository;
  @Autowired
  protected CustomerRepository customerRepository;
  @Autowired
  protected ItemRepository itemRepository;
  @Autowired
  protected PurchaseRepository purchaseRepository;

  @Autowired
  protected ObjectMapper objectMapper;
  protected MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).defaultResponseCharacterEncoding(StandardCharsets.UTF_8).build();
  }

  @AfterEach
  void tearDown() {
    databaseSequenceRepository.deleteAll();
    customerRepository.deleteAll();
    itemRepository.deleteAll();
    purchaseRepository.deleteAll();
  }

}
