package com.hust.doan.service.imp;

import com.hust.doan.exception.DataNotFoundException;
import com.hust.doan.model.Category;
import com.hust.doan.repository.CategoryRepository;
import com.hust.doan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category id: " + id));
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new DataNotFoundException("Categories");
        }
        return categories;
    }
}
