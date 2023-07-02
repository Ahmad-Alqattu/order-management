package org.example.service.impl;

import org.example.payload.OrderDto;
import org.example.entity.Order;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }




    @Override
    public List<OrderDto> getOrdersByCustomer(Integer orderId) {
        Order order = getOrderByIdFromRepository(orderId);
        return Collections.singletonList(modelMapper.map(order, OrderDto.class));
    }

    @Override
    public OrderDto createOrder(Integer customerId, OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Order createdOrder = orderRepository.save(order);
        return modelMapper.map(createdOrder, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(Integer orderId, OrderDto orderDto) {
        getOrderByIdFromRepository(orderId);
        Order updatedOrder = modelMapper.map(orderDto, Order.class);
        updatedOrder.setId(orderId);
        Order savedOrder = orderRepository.save(updatedOrder);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order = getOrderByIdFromRepository(orderId);
        orderRepository.delete(order);
    }

    private Order getOrderByIdFromRepository(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
    }
}
