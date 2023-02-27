package com.hust.doan.service.imp;

import com.hust.doan.exception.WebServiceException;
import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
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
            OrderFood orderFood = new OrderFood(orderFoodsDTO.getFood(), order, orderFoodsDTO.getAmount(), OrderFoodStatus.REQUEST);
            orderFoods.add(orderFoodRepository.save(orderFood));
        }
        return orderFoods;
    }

    @Override
    public OrderFood updateOrderFood(Long id) {
        OrderFood orderFood = orderFoodRepository.findById(id)
                .orElseThrow(() -> new WebServiceException("Cannot find OrderFood id: " + id));

        orderFood.setOrderFoodStatus(OrderFoodStatus.RESPONSE);
        return orderFoodRepository.save(orderFood);
    }

    @Override
    public List<OrderFood> getFoodsByStatus(OrderFoodStatus orderFoodStatus) {
        return orderFoodRepository.getOrderFoodsByOrderFoodStatus(orderFoodStatus);
    }
}
