package com.example.hibernate2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "SURNAME",nullable = false)
    private String surname;

    @Column(name = "AGE",nullable = false)
    private int age;

    @Column(name = "PHONE_NUMBER",nullable = false)
    private String phone_number;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="CUSTOMER_ID")
    private Set<Order> orders;
}
