package com.example.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.demo")
public class IntegrationTestConfig {

  /**
   * Check additional configuration
   * https://github.com/FasterXML/jackson-modules-java8
   * @return
   */
  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = JsonMapper.builder()
                                          //      .addModule(new ParameterNamesModule())
                                          //      .addModule(new Jdk8Module())
//                                          .addModule(new JavaTimeModule())
                                          .build();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper;
  }

}
