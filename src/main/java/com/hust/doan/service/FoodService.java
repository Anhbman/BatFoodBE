package com.hust.doan.service;

import com.hust.doan.model.Food;

import java.util.List;

public interface FoodService {
    public void save(Food food);

    List<Food> getAll();
}
