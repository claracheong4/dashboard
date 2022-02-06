package com.dashboard.controller;

import com.dashboard.model.Customer;
import com.dashboard.repository.CustomerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final Logger logger;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.logger = Logger.getLogger(CustomerController.class.getName());
    }

    @GetMapping
    public List<Customer> getCustomers(@RequestParam(required = false) Integer id,
                                       @RequestParam(required = false) String name) {
        logger.log(Level.INFO, "Get all customers");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", exact())
                .withMatcher("name", exact());
        Example<Customer> example = Example.of(customer, matcher);
        return customerRepository.findAll(example);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        logger.log(Level.INFO, "Get customer with id " + id);

        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws URISyntaxException {
        logger.log(Level.INFO, "Post customer with id " + customer.getId());

        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.created(new URI("/customers/" + savedCustomer.getId())).body(savedCustomer);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        logger.log(Level.INFO, "Put customer with id " + customer.getId());

        Customer currCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
        if (customer.getName() != null) currCustomer.setName(customer.getName());

        return ResponseEntity.ok(currCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        logger.log(Level.INFO, "Delete customer with id " + id);

        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}