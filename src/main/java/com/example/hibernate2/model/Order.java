package com.example.hibernate2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name="DATE")
    private Date date;

    @ManyToOne(cascade=CascadeType.ALL)
    private Customer customer;

    @Column(name="PRODUCT_NAME")
    private String product_name;

    @Column
    private int amount;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", product_name='" + product_name + '\'' +
                ", amount=" + amount +
                '}' +"\r";
    }
}
