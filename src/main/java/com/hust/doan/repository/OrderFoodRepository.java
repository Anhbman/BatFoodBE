package com.hust.doan.repository;

import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
    List<OrderFood> getOrderFoodsByOrderFoodStatus(OrderFoodStatus foodStatus);
}
