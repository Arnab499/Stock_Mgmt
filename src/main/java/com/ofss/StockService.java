package com.ofss;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // POST
    public ResponseEntity<Object> addStock(Stocks newStock) {
        return ResponseEntity.status(201).body(stockRepository.save(newStock));
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
}
