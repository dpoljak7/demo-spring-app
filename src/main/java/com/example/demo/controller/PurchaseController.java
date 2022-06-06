package com.example.demo.controller;

import com.example.demo.dto.PurchaseAllDataDto;
import com.example.demo.dto.PurchaseDto;
import com.example.demo.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/purchase")
@RestController
@RequiredArgsConstructor
public class PurchaseController {
  private final PurchaseService purchaseService;

  @GetMapping("filter-by-itemDescription/{itemDescription}/page/{page}/page/{size}")
  public List<PurchaseAllDataDto> filter(@PathVariable("itemDescription") String itemDescription, @PathVariable("page") int page, @PathVariable("size") int size) {
    return purchaseService.filterByItemDescription(itemDescription, PageRequest.of(page, size));
  }

}
