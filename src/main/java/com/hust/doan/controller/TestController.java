package com.hust.doan.controller;

import com.hust.doan.payload.request.ObjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @PostMapping("/")
    public Object index(@RequestBody ObjectDTO objectDTO) {
        Map<String, Object> Ext = (Map<String, Object>) objectDTO.getData();
        System.out.println("test: " + Ext.get("test"));
        System.out.println("hehe: " + Ext.get("hehe"));
        return Ext;
    }
}
