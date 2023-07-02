package org.example.service;

import org.example.payload.ProductDto;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Retrieves all products.
     *
     * @return List of product DTOs
     */
    List<ProductDto> getAllProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param productId ID of the product
     * @return Product DTO
     */
    ProductDto getProductById(Integer productId);

    /**
     * Creates a new product.
     *
     * @param productDto Product DTO
     * @return Created product DTO
     */
    ProductDto createProduct(ProductDto productDto);

    /**
     * Updates an existing product.
     *
     * @param productId  ID of the product to be updated
     * @param productDto Updated product DTO
     * @return Updated product DTO
     */
    ProductDto updateProduct(Integer productId, ProductDto productDto);

    /**
     * Deletes a product by its ID.
     *
     * @param productId ID of the product to be deleted
     */
    void deleteProduct(Integer productId);
}
