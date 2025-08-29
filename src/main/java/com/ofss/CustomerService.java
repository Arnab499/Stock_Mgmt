package com.ofss;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // POST
    public ResponseEntity<Object> addCustomer(Customers newCustomer) {
        return ResponseEntity.status(201).body(customerRepository.save(newCustomer));
    }

    // GET all
    public Iterable<Customers> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    // GET by ID
    public ResponseEntity<Customers> getCustomerById(int id) {
        Optional<Customers> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // DELETE by ID
    public ResponseEntity<String> deleteCustomerById(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
