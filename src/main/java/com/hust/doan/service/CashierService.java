package com.hust.doan.service;

import com.hust.doan.model.Order;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.response.RequestOrderDTO;

import java.util.List;

public interface CashierService {
    List<RequestOrderDTO> getRequestOrders();

    List<Order> getOrdersByStatus(OrderStatus orderStatus);
}
