package com.hust.doan.model;

import com.hust.doan.model.type.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Customer extends BaseEntity{

    private String fullname;

    private String phone;

    private Date birthday;

    private Long point;

    private Gender gender;
}
