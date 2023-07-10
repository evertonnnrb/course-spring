package com.dv.course.service;

import com.dv.course.entities.Order;
import com.dv.course.repositories.OrderRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRespository orderRespository;

    public List<Order> findAll() {
        return orderRespository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRespository.findById(id);
    }
}
