package com.example.demo.config;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Forwards request id from request sent by view to MDC
 */
public class RestLoggingInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    MDC.put("CorrelationId", String.valueOf(UUID.randomUUID()).substring(0, 8)); // can be increased
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    // clear mdc before request ends, before another request is assigned to this thread
    MDC.clear();
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

}
