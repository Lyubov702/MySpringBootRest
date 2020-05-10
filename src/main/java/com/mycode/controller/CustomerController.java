package com.mycode.controller;

import com.mycode.model.Customer;
import com.mycode.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @GetMapping ("/find")
    public ResponseEntity<Customer> findCustomerById (@RequestParam int id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/find/allCustomers")
    public ResponseEntity<List<Customer>> findAll () {
        List<Customer> customer = customerService.findAllCustomers();
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Customer> replaceCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        Customer replacedCustomer = customerService.replaceCustomer(customer, id);
        if (replacedCustomer != null)
            return ResponseEntity.ok(replacedCustomer);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findDistinctByLocation")
    public ResponseEntity<List<String>> findDistinctByLocation(){
        List<String> list= customerService.findDistinctByLocation();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNN")
    public ResponseEntity<List<String>> findByNN(){
        List<String> result = customerService.findByNN();
        if (result!=null)
            return ResponseEntity.ok(result);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
