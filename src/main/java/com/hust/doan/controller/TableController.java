package com.hust.doan.controller;


import com.hust.doan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("")
    public ResponseEntity<?> getAllTable() {
        return new ResponseEntity<>(tableService.getAll(), HttpStatus.OK);
    }
}
