package org.example.service;

import org.example.payload.ProductOrderDto;

import java.util.List;

/**
 * Service interface for managing product orders.
 */
public interface ProductOrderService {

    /**
     * Retrieves all product orders.
     *
     * @return List of product order DTOs
     */
    List<ProductOrderDto> getAllProductOrders();

    /**
     * Retrieves product orders for a specific order.
     *
     * @param orderId ID of the order
     * @return List of product order DTOs
     */
    List<ProductOrderDto> getProductOrdersByOrder(Integer orderId);

    /**
     * Creates a new product order.
     *
     * @param orderId         ID of the order
     * @param productOrderDto Product order DTO
     * @return Created product order DTO
     */
    ProductOrderDto createProductOrder(Integer orderId, ProductOrderDto productOrderDto);

    /**
     * Updates an existing product order.
     *
     * @param orderId         ID of the order
     * @param productOrderId  ID of the product order to be updated
     * @param productOrderDto Updated product order DTO
     * @return Updated product order DTO
     */
    ProductOrderDto updateProductOrder(Integer orderId, Integer productOrderId, ProductOrderDto productOrderDto);

    /**
     * Deletes a product order by its ID.
     *
     * @param orderId        ID of the order
     * @param productOrderId ID of the product order to be deleted
     */
    void deleteProductOrder(Integer orderId, Integer productOrderId);
}
