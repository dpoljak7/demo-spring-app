package com.example.demo.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {
  @Autowired
  private DemoProperties demoProperties;

  @Bean
  public MongoTemplate mongoTemplate() {
    return new MongoTemplate(MongoClients.create(demoProperties.getMongodbConnectionString()), "test");
  }
}
