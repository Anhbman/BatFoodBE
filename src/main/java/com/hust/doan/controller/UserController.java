package com.hust.doan.controller;

import com.hust.doan.service.IUserService;
import com.hust.doan.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/count")
    public ResponseEntity<?> getCount() {
        return new ResponseEntity<>(userService.countUser(), HttpStatus.OK);
    }
}
