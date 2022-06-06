package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * For regular units tests (not integration tests) since this will execute much faster.
 */
@ComponentScan("com.example.demo.mappers")
public class TestConfig {

}
