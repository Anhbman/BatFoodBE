package com.hust.doan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@javax.persistence.Table(name = "tables")
public class Table extends BaseEntity{

    private Long slot;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
