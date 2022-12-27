package com.hust.doan.payload.request;

import com.hust.doan.model.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

@Data
public class AddFoodDTO {
    private String name;
    @Min(value = 0, message = "Giá trị phải lớn hơn 0")
    private Float price;
    private MultipartFile image;
    private Category category;
}
