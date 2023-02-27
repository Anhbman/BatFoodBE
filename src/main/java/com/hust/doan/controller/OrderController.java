package com.hust.doan.controller;

import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.service.KitchenService;
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

    @Autowired
    private KitchenService kitchenService;

    @PostMapping()
    @Transactional
    public ResponseEntity<?> order(@Valid @RequestBody OrderDTO request,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderService.addOrder(request), HttpStatus.CREATED);
    }

    @GetMapping("/requestOrders")
    public ResponseEntity<?> getRequestOrders() {
        return new ResponseEntity<>(kitchenService.getOrderFoodsByStatus(OrderFoodStatus.REQUEST), HttpStatus.OK);
    }

    @PutMapping("/acceptFood/{id}")
    public ResponseEntity<?> updateOrderFood(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(orderFoodService.updateOrderFood(id), HttpStatus.OK);
    }

    @GetMapping("/responseFoods")
    public ResponseEntity<?> getResponseFoods() {
        return new ResponseEntity<>(kitchenService.getOrderFoodsByStatus(OrderFoodStatus.RESPONSE), HttpStatus.OK);
    }
}
