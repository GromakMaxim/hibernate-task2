package com.example.hibernate2.controller;

import com.example.hibernate2.service.DBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private DBService DBService;

    public ProductController(DBService DBService) {
        this.DBService = DBService;
    }
    //например
    //http://localhost:8080/products/fetch-product?name=%D0%92%D0%B5%D0%B4%D1%8C%D0%BC%D0%B0%D0%BA%20(%D0%B8%D0%B3%D1%80%D0%B0)
    @GetMapping("/products/fetch-product")
    public List getProduct(@RequestParam String name) {
        return DBService.getProductByName(name);
    }
}

