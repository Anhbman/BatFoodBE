package com.hust.doan.payload.response;

import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public interface RequestOrderDTO {

//    @Column(name = "id")
    Long getId();

//    @Column(name = "food_id")
    Long getFoodId();

//    @Column(name = "table_name")
    String getTableName();

//    @Column(name = "food_name")
    String getFoodName();

//    @Column(name = "amount")
    Long getAmount();

//    @Column(name = "created_date")
    Date getCreatedDate();
}
