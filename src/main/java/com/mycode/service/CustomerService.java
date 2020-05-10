package com.mycode.service;

import com.mycode.model.Customer;
import com.mycode.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer findById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }


    public void deleteById( int id) {
        customerRepository.deleteById(id);
    }


    public Customer replaceCustomer(Customer newCustomer, Integer id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setLocation(newCustomer.getLocation());
                    customer.setDiscount(newCustomer.getDiscount());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }

    public List<String> findDistinctByLocation () {
        return  customerRepository.findDistinctByLocation();
    }

    public List<String> findByNN () {
        return  customerRepository.findByNN();
    }
}
