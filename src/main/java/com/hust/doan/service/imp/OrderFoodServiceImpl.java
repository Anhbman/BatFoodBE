package com.hust.doan.service.imp;

import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.payload.request.OrderFoodsDTO;
import com.hust.doan.repository.OrderFoodRepository;
import com.hust.doan.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Override
    public List<OrderFood> addOrderFoods(Order order, List<OrderFoodsDTO> request) {
        List<OrderFood> orderFoods = new ArrayList<>();
        for (OrderFoodsDTO orderFoodsDTO : request) {
            OrderFood orderFood = new OrderFood(orderFoodsDTO.getFood(), order, orderFoodsDTO.getAmount());
            orderFoods.add(orderFoodRepository.save(orderFood));
        }
        return orderFoods;
    }
}
