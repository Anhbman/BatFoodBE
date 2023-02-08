package com.hust.doan.service.imp;

import com.hust.doan.model.Order;
import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.repository.OrderFoodRepository;
import com.hust.doan.repository.OrderRepository;
import com.hust.doan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Override
    public Order addOrder(OrderDTO request) {
        Order order = new Order(request.getTable());
        return orderRepository.save(order);

    }
}
