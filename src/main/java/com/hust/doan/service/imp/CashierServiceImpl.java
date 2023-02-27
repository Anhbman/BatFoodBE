package com.hust.doan.service.imp;

import com.hust.doan.model.Order;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.response.RequestOrderDTO;
import com.hust.doan.repository.OrderRepository;
import com.hust.doan.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<RequestOrderDTO> getRequestOrders() {
        return orderRepository.getRequestOrders();
    }

    @Override
    public List<Order> getOrdersByStatus(OrderFoodStatus orderStatus) {
        return null;
    }
}
