package org.example.service;

import org.example.payload.StockDto;

import java.util.List;

/**
 * Service interface for managing stocks.
 */
public interface StockService {

    /**
     * Retrieves all stocks.
     *
     * @return List of stock DTOs
     */
    List<StockDto> getAllStocks();

    /**
     * Retrieves stocks for a specific product.
     *
     * @param productId ID of the product
     * @return List of stock DTOs
     */
    List<StockDto> getStocksByProductId(Integer productId);

    /**
     * Updates the quantity of a stock for a specific product.
     *
     * @param productId  ID of the product
     * @param stockDto   Stock DTO with updated quantity
     * @return Updated stock DTO
     */
    StockDto updateStockQuantity(Integer productId, StockDto stockDto);

    StockDto createStock(Integer productId, StockDto stockDto);

    StockDto updateStock(Integer stockId, StockDto stockDto);

    void deleteStock(Integer stockId);
}
