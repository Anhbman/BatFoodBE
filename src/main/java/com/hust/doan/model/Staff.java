package com.hust.doan.model;

import com.hust.doan.model.type.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Staff {
    @Id
    private Long id;

    private String fullname;

    private Date birthday;

    private String phone;

    private Gender gender;
}
