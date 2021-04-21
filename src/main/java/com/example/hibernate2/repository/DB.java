package com.example.hibernate2.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DB {
    @PersistenceContext
    EntityManager entityManager;

    public List getProductByName(String name) {
        var query = entityManager.createQuery("select order from Order order where order.product_name=:name");
        query.setParameter("name", name);
        var list = query.getResultList();
        return list;
    }
}
