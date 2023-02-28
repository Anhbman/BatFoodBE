package com.hust.doan.service.imp;

import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.payload.response.OrderFoodsByStatusDTO;
import com.hust.doan.service.KitchenService;
import com.hust.doan.service.OrderFoodService;
import com.hust.doan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    private OrderFoodService orderFoodService;

    @Autowired
    private OrderService orderService;

    @Override
    public List<Order> getOrderFoodsByStatus(OrderFoodStatus orderFoodStatus) {
        List<OrderFood> orderFoods = orderFoodService.getFoodsByStatus(orderFoodStatus);

        List<Order> orders = new ArrayList<>();

        if (orderFoods.isEmpty()) {
            return orders;
        }

        orders.add(orderFoods.get(0).getOrder());
        orders.get(0).setOrderFoods(new HashSet<>());

        for  (OrderFood orderFood : orderFoods) {
            if (!orders.contains(orderFood.getOrder())) {
                orders.add(orderFood.getOrder());
                orders.get(orders.indexOf(orderFood.getOrder())).setOrderFoods(new HashSet<>());
            }
            orders.get(orders.indexOf(orderFood.getOrder())).getOrderFoods().add(orderFood);
        }
        return orders;
    }
}