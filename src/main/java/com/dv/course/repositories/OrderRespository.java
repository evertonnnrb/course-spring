package com.dv.course.repositories;

import com.dv.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Order, Long> {
}
