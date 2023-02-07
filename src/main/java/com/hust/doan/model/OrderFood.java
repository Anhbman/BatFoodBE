package com.hust.doan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderFood extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "food_id")
    @NotNull(message = "Food không được null")
    private Food food;


    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull(message = "Order không được null")
    private Order order;

    @NotNull(message = "amount không được null")
    private Long amount;
}
