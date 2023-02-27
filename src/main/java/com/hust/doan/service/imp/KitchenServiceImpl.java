package com.hust.doan.service.imp;

import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.payload.response.OrderFoodsByStatusDTO;
import com.hust.doan.service.KitchenService;
import com.hust.doan.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    private OrderFoodService orderFoodService;

    @Override
    public List<OrderFoodsByStatusDTO> getOrderFoodsByStatus(OrderFoodStatus orderFoodStatus) {
        List<OrderFood> orderFoods = orderFoodService.getFoodsByStatus(orderFoodStatus);

        List<OrderFoodsByStatusDTO>  result = new ArrayList<>();

        for (OrderFood orderFood :
                orderFoods) {
            OrderFoodsByStatusDTO tmp = new OrderFoodsByStatusDTO(orderFood, orderFood.getOrder().getTable());
            result.add(tmp);
        }
        return result;
    }
}
