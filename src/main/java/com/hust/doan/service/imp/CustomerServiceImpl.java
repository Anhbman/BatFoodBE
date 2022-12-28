package com.hust.doan.service.imp;

import com.hust.doan.model.Customer;
import com.hust.doan.payload.request.CreateCustomerDTO;
import com.hust.doan.repository.CustomerRepository;
import com.hust.doan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(CreateCustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFullname(customerDTO.getName());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setPhone(customerDTO.getPhone());
        return customerRepository.save(customer);
    }

    @Override
    public Long countCustomer() {
        return customerRepository.countCustomer();
    }
}
