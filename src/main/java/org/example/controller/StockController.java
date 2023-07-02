package org.example.controller;

import org.example.payload.StockDto;
import org.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing stocks.
 */
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Retrieves all stocks.
     *
     * @return List of stock DTOs
     */
    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStocks() {
        List<StockDto> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    /**
     * Retrieves stocks for a specific product.
     *
     * @param productId ID of the product
     * @return List of stock DTOs
     */
    @GetMapping("/{productId}")
    public ResponseEntity<List<StockDto>> getStocksByProductId(@PathVariable Integer productId) {
        List<StockDto> stocks = stockService.getStocksByProductId(productId);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    /**
     * Creates a new stock for a product.
     *
     * @param productId ID of the product
     * @param stockDto  Stock DTO
     * @return Created stock DTO
     */
    @PostMapping("/{productId}")
    public ResponseEntity<StockDto> createStock(
            @PathVariable Integer productId,
            @RequestBody StockDto stockDto
    ) {
        StockDto createdStock = stockService.createStock(productId, stockDto);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    /**
     * Updates an existing stock.
     *
     * @param stockId  ID of the stock to be updated
     * @param stockDto Updated stock DTO
     * @return Updated stock DTO
     */
    @PutMapping("/{stockId}")
    public ResponseEntity<StockDto> updateStock(
            @PathVariable Integer stockId,
            @RequestBody StockDto stockDto
    ) {
        StockDto updatedStock = stockService.updateStock(stockId, stockDto);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    /**
     * Deletes a stock by its ID.
     *
     * @param stockId ID of the stock to be deleted
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{stockId}")
    public ResponseEntity<Void> deleteStock(@PathVariable Integer stockId) {
        stockService.deleteStock(stockId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
