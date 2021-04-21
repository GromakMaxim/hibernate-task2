package com.example.hibernate2.service;

import com.example.hibernate2.repository.DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    private DB repository;

    public DBService(DB repository) {
        this.repository = repository;
    }

    public List getProductByName(String name) {
        return repository.getProductByName(name);
    }
}
