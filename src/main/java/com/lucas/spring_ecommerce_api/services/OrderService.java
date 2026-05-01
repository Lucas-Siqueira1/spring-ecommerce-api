package com.lucas.spring_ecommerce_api.services;

import com.lucas.spring_ecommerce_api.entities.Order;
import com.lucas.spring_ecommerce_api.repository.OrderRepository;
import com.lucas.spring_ecommerce_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Integer id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order update(Integer id, Order newOrder) {
        Order oldOrder = orderRepository.getReferenceById(id);
        oldOrder.setOrderStatus(newOrder.getOrderStatus());
        return orderRepository.save(oldOrder);
    }


}
