package com.hust.doan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderFood> orderFoods;

    public Order(Table table) {
        this.table = table;
    }
}
