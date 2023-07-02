package org.example.service.impl;

import org.example.payload.ProductOrderDto;
import org.example.entity.ProductOrder;
import org.example.entity.Order;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.ProductOrderRepository;
import org.example.repository.OrderRepository;
import org.example.service.ProductOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.productOrderRepository = productOrderRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductOrderDto> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        return productOrders.stream()
                .map(productOrder -> modelMapper.map(productOrder, ProductOrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOrderDto> getProductOrdersByOrder(Integer orderId) {
        Order order = getOrderByIdFromRepository(orderId);
        List<ProductOrder> productOrders = productOrderRepository.findAllById(Collections.singleton(orderId));
        return productOrders.stream()
                .map(productOrder -> modelMapper.map(productOrder, ProductOrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductOrderDto createProductOrder(Integer orderId, ProductOrderDto productOrderDto) {
        Order order = getOrderByIdFromRepository(orderId);
        ProductOrder productOrder = modelMapper.map(productOrderDto, ProductOrder.class);
        productOrder.setOrder(order);
        ProductOrder createdProductOrder = productOrderRepository.save(productOrder);
        return modelMapper.map(createdProductOrder, ProductOrderDto.class);
    }

    @Override
    public ProductOrderDto updateProductOrder(Integer orderId, Integer productOrderId, ProductOrderDto productOrderDto) {
        getOrderByIdFromRepository(orderId);
        ProductOrder updatedProductOrder = getProductOrderByIdFromRepository(productOrderId);
        updatedProductOrder.setQuantity(productOrderDto.getQuantity());
        updatedProductOrder.setPrice(productOrderDto.getPrice());
        updatedProductOrder.setVat(productOrderDto.getVat());
        ProductOrder savedProductOrder = productOrderRepository.save(updatedProductOrder);
        return modelMapper.map(savedProductOrder, ProductOrderDto.class);
    }

    @Override
    public void deleteProductOrder(Integer orderId, Integer productOrderId) {
        getOrderByIdFromRepository(orderId);
        ProductOrder productOrder = getProductOrderByIdFromRepository(productOrderId);
        productOrderRepository.delete(productOrder);
    }

    private Order getOrderByIdFromRepository(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
    }

    private ProductOrder getProductOrderByIdFromRepository(Integer productOrderId) {
        return productOrderRepository.findById(productOrderId)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOrder", "id", productOrderId));
    }
}
