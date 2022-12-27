package com.hust.doan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Food extends BaseEntity{

    private String name;

    private Float price;

    @OneToMany(mappedBy = "food")
    private Set<OrderFood> orderFoods;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String image;
}
