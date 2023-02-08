package com.hust.doan.payload.request;

import com.hust.doan.model.Food;
import com.hust.doan.model.Table;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDTO {
    @NotNull(message = "Không được để trống bàn")
    private Table table;
    @NotNull(message = "Món ăn khong được để trống")
    private List<OrderFoodsDTO> orderFood;
}
