package com.hust.doan.service;

import com.hust.doan.payload.response.RequestOrderDTO;

import java.util.List;

public interface CashierService {
    List<RequestOrderDTO> getRequestOrders();
}
