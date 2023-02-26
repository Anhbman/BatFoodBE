package com.hust.doan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hust.doan.model.type.OrderFoodStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Food extends BaseEntity{

    private String name;

    private Float price;

    @OneToMany(mappedBy = "food")
    @JsonIgnore
    private Set<OrderFood> orderFoods;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    private String image;
}
