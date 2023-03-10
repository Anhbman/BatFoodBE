package com.hust.doan.repository;

import com.hust.doan.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "select count(id) from Food")
    Long countFood();
}
