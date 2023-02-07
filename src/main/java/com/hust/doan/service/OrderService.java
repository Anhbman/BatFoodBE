package com.hust.doan.service;

import com.hust.doan.model.Order;
import com.hust.doan.payload.request.OrderDTO;

public interface OrderService {
    Order addOrder(OrderDTO request);
}
