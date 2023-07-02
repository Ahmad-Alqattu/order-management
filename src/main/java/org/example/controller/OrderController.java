package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.payload.OrderDto;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Api(value = "Order API", tags = "Orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Get orders for a specific customer")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomer(@PathVariable Integer customerId) {
        List<OrderDto> orders = orderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/{customerId}")
    @ApiOperation(value = "Create a new order for a customer")
    public ResponseEntity<OrderDto> createOrder(@PathVariable Integer customerId, @RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(customerId, orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{orderId}")
    @ApiOperation(value = "Update an existing order")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Integer orderId, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderId, orderDto);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    @ApiOperation(value = "Delete an order")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
