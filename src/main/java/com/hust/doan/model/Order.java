package com.hust.doan.model;

import com.hust.doan.model.type.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "orders")
@NoArgsConstructor
@Data
public class Order extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderFood> orderFoods;

    private OrderStatus orderStatus;

    public Order(Table table) {
        this.table = table;
    }
}
