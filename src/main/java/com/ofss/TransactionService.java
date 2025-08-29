package com.ofss;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // POST
    public ResponseEntity<Object> addTransaction(Transactions newTransaction) {
        return ResponseEntity.status(201).body(transactionRepository.save(newTransaction));
    }

    // GET all
    public Iterable<Transactions> fetchAllTransactions() {
        return transactionRepository.findAll();
    }

    // GET by ID
    public ResponseEntity<Transactions> getTransactionById(int id) {
        Optional<Transactions> txn = transactionRepository.findById(id);
        return txn.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // DELETE by ID
    public ResponseEntity<String> deleteTransactionById(int id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok("Transaction deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
