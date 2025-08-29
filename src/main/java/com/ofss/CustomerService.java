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
 // PUT – Full update
    public ResponseEntity<Customers> updateCustomer(int id, Customers updatedCustomer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirstName(updatedCustomer.getFirstName());
                    existingCustomer.setLastName(updatedCustomer.getLastName());
                    existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    existingCustomer.setCity(updatedCustomer.getCity());
                    existingCustomer.setEmailId(updatedCustomer.getEmailId());
                    // Save and return
                    customerRepository.save(existingCustomer);
                    return ResponseEntity.ok(existingCustomer);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH – Partial update
    public ResponseEntity<Customers> partiallyUpdateCustomer(int id, Customers partialCustomer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    if (partialCustomer.getFirstName() != null) {
                        existingCustomer.setFirstName(partialCustomer.getFirstName());
                    }
                    if (partialCustomer.getLastName() != null) {
                        existingCustomer.setLastName(partialCustomer.getLastName());
                    }
                    if (partialCustomer.getPhoneNumber() != null) {
                        existingCustomer.setPhoneNumber(partialCustomer.getPhoneNumber());
                    }
                    if (partialCustomer.getCity() != null) {
                        existingCustomer.setCity(partialCustomer.getCity());
                    }
                    if (partialCustomer.getEmailId() != null) {
                        existingCustomer.setEmailId(partialCustomer.getEmailId());
                    }
                    // Save and return
                    customerRepository.save(existingCustomer);
                    return ResponseEntity.ok(existingCustomer);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
