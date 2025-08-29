package com.ofss;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // POST
    public ResponseEntity<Object> addStock(Stocks newStock) {
        // Option 1: If stocks have a unique id
        if (newStock.getStockId() != null && stockRepository.existsById(newStock.getStockId())) {
            // Stock with this id already exists
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Stock already exists with id: " + newStock.getStockId());
        }
        Stocks saved = stockRepository.save(newStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // GET all
    public Iterable<Stocks> fetchAllStocks() {
        return stockRepository.findAll();
    }

    // GET by ID
    public ResponseEntity<Stocks> getStockById(int id) {
        Optional<Stocks> stock = stockRepository.findById(id);
        return stock.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // DELETE by ID
    public ResponseEntity<String> deleteStockById(int id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
            return ResponseEntity.ok("Stock deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
    
 // PUT – Full update
    public ResponseEntity<Stocks> updateStock(int id, Stocks updatedStock) {
        return stockRepository.findById(id)
                .map(existingStock -> {
                    existingStock.setStockName(updatedStock.getStockName());
                    existingStock.setStockPrice(updatedStock.getStockPrice());
                    existingStock.setStockVolume(updatedStock.getStockVolume());
                    existingStock.setListedDate(updatedStock.getListedDate());
                    existingStock.setListedExchange(updatedStock.getListedExchange());
                    existingStock.setListingPrice(updatedStock.getListingPrice());
                    // Add other fields if your entity has more
                    stockRepository.save(existingStock);
                    return ResponseEntity.ok(existingStock);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH – Partial update
    public ResponseEntity<Stocks> partiallyUpdateStock(int id, Stocks partialStock) {
        return stockRepository.findById(id)
                .map(existingStock -> {
                    if (partialStock.getStockName() != null) {
                        existingStock.setStockName(partialStock.getStockName());
                    }
                    if (partialStock.getStockPrice() != null) {
                        existingStock.setStockPrice(partialStock.getStockPrice());
                    }
                    if (partialStock.getStockVolume() != null) {
                        existingStock.setStockVolume(partialStock.getStockVolume());
                    }
                    if(partialStock.getListedDate()!=null) {
                    	existingStock.setListedDate(partialStock.getListedDate());
                    }
                    if(partialStock.getListedExchange()!=null) {
                    	existingStock.setListedExchange(partialStock.getListedExchange());
                    }
                    if(partialStock.getListingPrice()!=null) {
                    	existingStock.setListingPrice(partialStock.getListingPrice());
                    }
                    stockRepository.save(existingStock);
                    return ResponseEntity.ok(existingStock);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
