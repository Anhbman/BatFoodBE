package com.hust.doan.service;

import com.hust.doan.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category findById(Long id);

    List<Category> getAll();
}
