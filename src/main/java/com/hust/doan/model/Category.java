package com.hust.doan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Category extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Food> foods;

}
