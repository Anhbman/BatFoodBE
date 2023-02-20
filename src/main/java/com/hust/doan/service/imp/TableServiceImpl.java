package com.hust.doan.service.imp;

import com.hust.doan.exception.DataNotFoundException;
import com.hust.doan.model.Table;
import com.hust.doan.repository.TableRepository;
import com.hust.doan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public List<Table> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table findById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Table id: " + id));
    }
}
