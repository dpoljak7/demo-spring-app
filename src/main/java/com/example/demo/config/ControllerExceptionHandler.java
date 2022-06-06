package com.example.demo.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice("com.example.demo")
@RequiredArgsConstructor
public class ControllerExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<RuntimeException> handleAnyException(Exception exception, HttpServletRequest request) throws Exception {

    log.error("Controller exception:", exception);
    throw new RuntimeException("REST Exception", exception);
  }

}
