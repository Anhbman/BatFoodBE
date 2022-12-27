package com.hust.doan.model;

import com.hust.doan.model.type.Gender;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Customer extends BaseEntity{

    private String fullname;

    private String phone;

    private Date birthday;

    private Long point;

    private Gender gender;
}
