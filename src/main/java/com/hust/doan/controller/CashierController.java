package com.hust.doan.controller;

import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/cashier")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    @GetMapping
    public ResponseEntity<?> getRequestOrders() {
        return new ResponseEntity<>(cashierService.getOrdersByStatus(OrderFoodStatus.REQUEST), HttpStatus.OK);
    }
}
