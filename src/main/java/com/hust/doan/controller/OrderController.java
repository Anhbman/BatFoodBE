package com.hust.doan.controller;

import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.service.OrderFoodService;
import com.hust.doan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderFoodService orderFoodService;

    @PostMapping()
    @Transactional
    public ResponseEntity<?> order(@Valid @RequestBody OrderDTO request,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderService.addOrder(request), HttpStatus.CREATED);
    }
}
