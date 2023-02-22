package com.hust.doan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
