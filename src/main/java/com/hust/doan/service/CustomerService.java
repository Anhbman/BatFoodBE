package com.hust.doan.service;

import com.hust.doan.model.Customer;
import com.hust.doan.payload.request.CreateCustomerDTO;

public interface CustomerService {

    Customer save(CreateCustomerDTO customerDTO);

    Long countCustomer();
}
