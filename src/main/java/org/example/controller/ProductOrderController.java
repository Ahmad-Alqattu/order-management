package org.example.controller;

import org.example.entity.ProductOrder;
import org.example.payload.ProductOrderDto;
import org.example.service.ProductOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/product-orders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, ModelMapper modelMapper) {
        this.productOrderService = productOrderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ProductOrderDto> getAllProductOrders() {
        List<ProductOrderDto> productOrderDtos = productOrderService.getAllProductOrders();
        return productOrderDtos;
    }

    @GetMapping("/order/{orderId}")
    public List<ProductOrderDto> getProductOrdersByOrder(@PathVariable Integer orderId) {
        List<ProductOrderDto> productOrderDtos = productOrderService.getProductOrdersByOrder(orderId);
        return productOrderDtos;
    }

    @PostMapping("/order/{orderId}")
    public ResponseEntity<ProductOrderDto> createProductOrder(@PathVariable Integer orderId, @RequestBody ProductOrderDto productOrderDto) {
        ProductOrderDto createdProductOrderDto = productOrderService.createProductOrder(orderId, productOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductOrderDto);
    }

    @PutMapping("/order/{orderId}/product/{productOrderId}")
    public ResponseEntity<ProductOrderDto> updateProductOrder(@PathVariable Integer orderId, @PathVariable Integer productOrderId, @RequestBody ProductOrderDto productOrderDto) {
        ProductOrderDto updatedProductOrderDto = productOrderService.updateProductOrder(orderId, productOrderId, productOrderDto);
        return ResponseEntity.ok(updatedProductOrderDto);
    }

    @DeleteMapping("/order/{orderId}/product/{productOrderId}")
    public ResponseEntity<String> deleteProductOrder(@PathVariable Integer orderId, @PathVariable Integer productOrderId) {
        productOrderService.deleteProductOrder(orderId, productOrderId);
        return ResponseEntity.ok("Product Order deleted successfully");
    }
}
