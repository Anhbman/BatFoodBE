package com.hust.doan.repository;

import com.hust.doan.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
}
