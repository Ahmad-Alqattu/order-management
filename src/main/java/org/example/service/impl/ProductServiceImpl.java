package org.example.service.impl;

import org.example.payload.ProductDto;
import org.modelmapper.ModelMapper;
import org.example.entity.Product;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product = getProductByIdFromRepository(productId);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product createdProduct = productRepository.save(product);
        return modelMapper.map(createdProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        getProductByIdFromRepository(productId);
        Product updatedProduct = modelMapper.map(productDto, Product.class);
        updatedProduct.setId(productId);
        Product savedProduct = productRepository.save(updatedProduct);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = getProductByIdFromRepository(productId);
        productRepository.delete(product);
    }

    private Product getProductByIdFromRepository(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }
}
