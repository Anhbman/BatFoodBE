package com.hust.doan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderFood extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "food_id")
    @NotNull(message = "Food không được null")
    private Food food;


    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull(message = "Order không được null")
    @JsonIgnore
    private Order order;

    @NotNull(message = "amount không được null")
    private Long amount;
}
