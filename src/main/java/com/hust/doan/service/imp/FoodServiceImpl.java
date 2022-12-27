package com.hust.doan.service.imp;

import com.hust.doan.model.Food;
import com.hust.doan.repository.FoodRepository;
import com.hust.doan.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }
}
