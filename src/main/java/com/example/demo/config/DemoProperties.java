package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties(prefix="demo")
@Getter
@Setter
@Validated
public class DemoProperties {

  @NotBlank
  private String mongodbConnectionString;

}
