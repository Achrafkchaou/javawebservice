package com.bezkoder.spring.hibernate.manytomany.repository;

import java.util.List;

import com.bezkoder.spring.hibernate.manytomany.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {
    @Autowired
    CustomerRepository custRepository;

    // CREATE
    public Customer createCustomer(Customer cust) {
        return custRepository.save(cust);
    }

    // READ
    public List<Customer> getClients() {
        return custRepository.findAll();
    }

    // DELETE
    public void deleteCustomer(Long empId) {
        custRepository.deleteById(empId);
    }

    // UPDATE
    public Customer updateCustomer(Long custId, Customer customerDetails) {
        Customer cust = custRepository.findById(custId).get();
        cust.setFirstName(customerDetails.getFirstName());
        cust.setLastName(customerDetails.getLastName());
        cust.setEmailId(customerDetails.getEmailId());

        return custRepository.save(cust);
    }
}