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
 // PUT – Full update
    public ResponseEntity<Transactions> updateTransaction(int id, Transactions updatedTransaction) {
        return transactionRepository.findById(id)
                .map(existingTransaction -> {
                    existingTransaction.setCustId(updatedTransaction.getCustId());
                    existingTransaction.setStockId(updatedTransaction.getStockId());
                    existingTransaction.setTxnPrice(updatedTransaction.getTxnPrice());
                    existingTransaction.setTxnType(updatedTransaction.getTxnType());
                    existingTransaction.setQty(updatedTransaction.getQty());
                    existingTransaction.setTxnDate(updatedTransaction.getTxnDate());
                    // Save and return
                    transactionRepository.save(existingTransaction);
                    return ResponseEntity.ok(existingTransaction);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH – Partial update
    public ResponseEntity<Transactions> partiallyUpdateTransaction(int id, Transactions partialTransaction) {
        return transactionRepository.findById(id)
                .map(existingTransaction -> {
                    if (partialTransaction.getCustId() != null) {
                        existingTransaction.setCustId(partialTransaction.getCustId());
                    }
                    if (partialTransaction.getStockId() != null) {
                        existingTransaction.setStockId(partialTransaction.getStockId());
                    }
                    if (partialTransaction.getTxnPrice() != null) {
                        existingTransaction.setTxnPrice(partialTransaction.getTxnPrice());
                    }
                    if (partialTransaction.getTxnType() != null) {
                        existingTransaction.setTxnType(partialTransaction.getTxnType());
                    }
                    if (partialTransaction.getQty() != null) {
                        existingTransaction.setQty(partialTransaction.getQty());
                    }
                    if (partialTransaction.getTxnDate() != null) {
                        existingTransaction.setTxnDate(partialTransaction.getTxnDate());
                    }
                    // Save and return
                    transactionRepository.save(existingTransaction);
                    return ResponseEntity.ok(existingTransaction);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
