package com.hust.doan.controller;

import com.hust.doan.payload.request.CreateCustomerDTO;
import com.hust.doan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.save(customerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCountCustomer() {
        return new ResponseEntity<>(customerService.countCustomer(), HttpStatus.OK);
    }
}
