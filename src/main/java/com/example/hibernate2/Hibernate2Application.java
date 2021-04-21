package com.example.hibernate2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hibernate2")
public class Hibernate2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hibernate2Application.class, args);
    }

}
