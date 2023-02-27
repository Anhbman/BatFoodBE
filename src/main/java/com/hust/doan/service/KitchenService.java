package com.hust.doan.service;

import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.payload.response.OrderFoodsByStatusDTO;

import java.util.List;

public interface KitchenService {
    List<OrderFoodsByStatusDTO> getOrderFoodsByStatus(OrderFoodStatus orderFoodStatus);
}
