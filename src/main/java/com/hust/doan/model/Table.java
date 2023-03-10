package com.hust.doan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@javax.persistence.Table(name = "tables")
@Data
public class Table extends BaseEntity{

    private String name;

    private Long slot;

    @OneToMany(mappedBy = "table")
    @JsonIgnore
    private List<Order> orders;

//    1: Đang sử dụng
    private Boolean status;

//    1: Không sử dụng  được
    private Boolean active;
}
