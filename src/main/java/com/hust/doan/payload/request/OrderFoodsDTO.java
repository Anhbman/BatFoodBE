package com.hust.doan.payload.request;

import com.hust.doan.model.Food;
import lombok.Data;

@Data
public class OrderFoodsDTO {
    private Food food;
    private Long amount;
}
