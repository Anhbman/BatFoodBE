package com.hust.doan.controller;

import com.hust.doan.model.Category;
import com.hust.doan.model.Food;
import com.hust.doan.payload.request.AddFoodDTO;
import com.hust.doan.service.CategoryService;
import com.hust.doan.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private CategoryService categoryService;

    @Value("${upload.path}")
    private String fileUpload;

    @PostMapping
    public ResponseEntity<?> addFood(@Valid @ModelAttribute AddFoodDTO addFoodDTO,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Category category = categoryService.findById(addFoodDTO.getCategory().getId());
        Food food = new Food();
        food.setName(addFoodDTO.getName());
        food.setCategory(category);
        food.setPrice(addFoodDTO.getPrice());
        foodService.save(food);
        this.addFile(addFoodDTO.getImage(), food);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(foodService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCountFood() {
        return new ResponseEntity<>(foodService.countFood(), HttpStatus.OK);
    }

    private void addFile(MultipartFile file, Food food) {
            try {
                var fileName = file.getOriginalFilename();
                var is = file.getInputStream();
                Files.copy(is, Paths.get(this.fileUpload + fileName), StandardCopyOption.REPLACE_EXISTING);
                food.setImage(fileName);
                foodService.save(food);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
