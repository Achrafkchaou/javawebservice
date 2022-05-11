package com.bezkoder.spring.hibernate.manytomany.controller;

import java.util.List;

import com.bezkoder.spring.hibernate.manytomany.model.Customer;
import com.bezkoder.spring.hibernate.manytomany.repository.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService custService;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer cust) {
        return custService.createCustomer(cust);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Customer> readClients() {
        return custService.getClients();
    }

    @RequestMapping(value = "/clients/{custId}", method = RequestMethod.PUT)
    public Customer updatecustomer(@PathVariable(value = "custId") Long id, @RequestBody Customer custDetails) {
        return custService.updateCustomer(id, custDetails);
    }

    @RequestMapping(value = "/clients/{custId}", method = RequestMethod.DELETE)
    public String deleteClients(@PathVariable(value = "custId") Long id) {
        custService.deleteCustomer(id);
        return "customer deleted by id : " + id;
    }
}
