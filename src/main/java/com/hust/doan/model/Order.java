package com.hust.doan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderFood> orderFoods;
}
