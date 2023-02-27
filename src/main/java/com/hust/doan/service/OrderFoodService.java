package com.hust.doan.service;

import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.payload.request.OrderFoodsDTO;

import java.util.List;

public interface OrderFoodService {
    List<OrderFood> addOrderFoods(Order order, List<OrderFoodsDTO> request);

    OrderFood updateOrderFood(Long id);

    List<OrderFood> getFoodsByStatus(OrderFoodStatus orderFoodStatus);

}
