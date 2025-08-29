package com.ofss;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    // POST – Add a new customer
    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public ResponseEntity<Object> addCustomer(@RequestBody Customers newCustomer) {
        return customerService.addCustomer(newCustomer);
    }

    // GET – Fetch all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> fetchAll() {
        List<Customers> allCustomers = (List<Customers>) customerRepository.findAll();
        return ResponseEntity.ok(allCustomers);
    }

    // GET – Fetch a single customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    // DELETE – Remove a customer by ID
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }
}
