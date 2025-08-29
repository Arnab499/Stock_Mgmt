package com.ofss;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    // POST – Add a new stock
    @RequestMapping(value = "/stocks", method = RequestMethod.POST)
    public ResponseEntity<Object> addStock(@RequestBody Stocks newStock) {
        return stockService.addStock(newStock); // uses service layer
    }

    // GET – Fetch all stocks
    @GetMapping("/stocks")
    public ResponseEntity<List<Stocks>> fetchAllStocks() {
        List<Stocks> allStocks = (List<Stocks>) stockRepository.findAll();
        return ResponseEntity.ok(allStocks);
    }

    // GET – Fetch a single stock by ID
    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stocks> getStockById(@PathVariable int id) {
        return stockService.getStockById(id);
    }

    // DELETE – Remove a stock by ID
    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String> deleteStockById(@PathVariable int id) {
        return stockService.deleteStockById(id);
    }
}
