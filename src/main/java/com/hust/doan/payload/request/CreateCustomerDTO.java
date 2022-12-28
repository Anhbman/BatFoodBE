package com.hust.doan.payload.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateCustomerDTO {
    private String name;
    private String phone;
    private Date birthday;
}
