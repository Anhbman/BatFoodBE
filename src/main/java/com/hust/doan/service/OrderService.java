package com.hust.doan.service;

import com.hust.doan.model.Order;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.request.OrderDTO;

import java.util.List;

public interface OrderService {
    Order addOrder(OrderDTO request);

    List<Order> getOrdersByStatus(OrderStatus orderStatus);
}
