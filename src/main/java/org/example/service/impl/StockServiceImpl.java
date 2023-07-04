package org.example.service.impl;

import org.example.payload.StockDto;
import org.example.entity.Stock;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.StockRepository;
import org.example.repository.UserRepository;
import org.example.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, ModelMapper modelMapper) {
        this.stockRepository = stockRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StockDto> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(stock -> modelMapper.map(stock, StockDto.class))
                .collect(Collectors.toList());
    }



    @Override
    public StockDto updateStockQuantity(Integer productId, StockDto stockDto) {
        return null;
    }


    @Override
    public List<StockDto> getStocksByProductId(Integer stockId) {
        Stock stock = getStockByIdFromRepository(stockId);
        return Collections.singletonList(modelMapper.map(stock, StockDto.class));
    }

    @Override
    public  StockDto createStock(Integer productId, StockDto stockDto) {
        Stock stock = modelMapper.map(stockDto, Stock.class);
        Stock createdStock = stockRepository.save(stock);
        return modelMapper.map(createdStock, StockDto.class);
    }

    @Override
    public StockDto updateStock(Integer stockId, StockDto stockDto) {
        getStockByIdFromRepository(stockId);
        Stock updatedStock = modelMapper.map(stockDto, Stock.class);
        updatedStock.setId(stockId);
        Stock savedStock = stockRepository.save(updatedStock);
        return modelMapper.map(savedStock, StockDto.class);
    }

    @Override
    public void deleteStock(Integer stockId) {
        Stock stock = getStockByIdFromRepository(stockId);

        stockRepository.delete(stock);
    }

    private Stock getStockByIdFromRepository(Integer stockId) {
        return stockRepository.findById(stockId)

                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
    }
}
