package com.hust.doan.payload.response;

import com.hust.doan.model.OrderFood;
import com.hust.doan.model.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderFoodsByStatusDTO {
    private OrderFood orderFood;
    private Table table;
}
