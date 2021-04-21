package com.example.hibernate2.controller;

import com.example.hibernate2.service.DBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private DBService DBService;

    public ProductController(DBService DBService) {
        this.DBService = DBService;
    }

    @GetMapping("/products/fetch-product")
    public String getProduct(@RequestParam String name) {
        return DBService.getProductByName(name);
    }
}

