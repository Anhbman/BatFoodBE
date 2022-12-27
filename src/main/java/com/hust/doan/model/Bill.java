package com.hust.doan.model;

import com.hust.doan.model.type.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Double price;

    private Status status;

    private String note;
}
