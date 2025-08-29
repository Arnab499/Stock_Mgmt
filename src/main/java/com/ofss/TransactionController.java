package com.ofss;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    // POST – Add a new transaction
    @RequestMapping(value="/transactions", method=RequestMethod.POST)
    public ResponseEntity<Object> addTransaction(@RequestBody Transactions newTransaction) {
        return transactionService.addTransaction(newTransaction);
    }

    // GET – Fetch all transactions
    @GetMapping("/transactions")
    public ResponseEntity<List<Transactions>> fetchAll() {
        List<Transactions> allTransactions = (List<Transactions>) transactionRepository.findAll();
        return ResponseEntity.ok(allTransactions);
    }

    // GET – Fetch a single transaction by ID
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    // DELETE – Remove a transaction by ID
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable int id) {
        return transactionService.deleteTransactionById(id);
    }
}
