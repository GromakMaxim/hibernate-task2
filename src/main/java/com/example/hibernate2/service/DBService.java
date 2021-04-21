package com.example.hibernate2.service;

import com.example.hibernate2.repository.DB;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    private DB repository;

    public DBService(DB repository) {
        this.repository = repository;
    }

    public String getProductByName(String name) {
        return repository.getProductByName(name);
    }
}
