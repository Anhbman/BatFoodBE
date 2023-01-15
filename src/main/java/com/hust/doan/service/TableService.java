package com.hust.doan.service;

import com.hust.doan.model.Table;
import org.hibernate.validator.constraints.CodePointLength;

import java.util.List;

public interface TableService {

    List<Table> getAll();
}
