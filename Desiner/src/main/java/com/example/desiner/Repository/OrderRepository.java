package com.example.desiner.Repository;

import com.example.desiner.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findOrderById(Integer id);

    Order findOrderByStatus(String status);

    List<Order> findOrdersByDesigner(Designer designer);

    List<Order> findOrderByArea(Integer area);
}
