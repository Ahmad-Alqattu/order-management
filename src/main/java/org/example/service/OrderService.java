package org.example.service;

import org.example.payload.OrderDto;

import java.util.List;

/**
 * Service interface for managing orders.
 */
public interface OrderService {

    /**
     * Retrieves all orders.
     *
     * @return List of order DTOs
     */
    List<OrderDto> getAllOrders();

    /**
     * Retrieves orders for a specific customer.
     *
     * @param customerId ID of the customer
     * @return List of order DTOs
     */
    List<OrderDto> getOrdersByCustomer(Integer customerId);

    /**
     * Creates a new order.
     *
     * @param customerId ID of the customer
     * @param orderDto   Order DTO
     * @return Created order DTO
     */
    OrderDto createOrder(Integer customerId, OrderDto orderDto);

    /**
     * Updates an existing order.
     *
     * @param orderId  ID of the order to be updated
     * @param orderDto Updated order DTO
     * @return Updated order DTO
     */
    OrderDto updateOrder(Integer orderId, OrderDto orderDto);

    /**
     * Deletes an order by its ID.
     *
     * @param orderId ID of the order to be deleted
     */
    void deleteOrder(Integer orderId);
}
