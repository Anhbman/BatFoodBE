package com.hust.doan.service.imp;

import com.hust.doan.exception.WebServiceException;
import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.Table;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.request.OrderDTO;
import com.hust.doan.repository.OrderFoodRepository;
import com.hust.doan.repository.OrderRepository;
import com.hust.doan.service.OrderFoodService;
import com.hust.doan.service.OrderService;
import com.hust.doan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderFoodService orderFoodService;

    @Autowired
    private TableService tableService;

    @Override
    public Order addOrder(OrderDTO request) {
        Table table = tableService.findById(request.getTable().getId());
        if (table.getActive() != null && !table.getActive()) {
            throw new WebServiceException("Bàn " + table.getName() + " không được active!");
        }

        if (table.getStatus() != null && table.getStatus()) {
            throw new WebServiceException("Bàn " + table.getName() + " đang được sử dụng!");
        }
        table.setStatus(Boolean.TRUE);
        tableService.save(table);
        Order order = new Order(request.getTable());
//        order.setOrderStatus(OrderStatus.REQUEST);
        orderFoodService.addOrderFoods(orderRepository.save(order), request.getOrderFood());
        return order;
    }

    @Override
    public List<Order> getOrdersByStatus(OrderFoodStatus foodStatus) {
        List<Order> orders = new ArrayList<>();
        return orderRepository.getOrderFoodsByStatus(foodStatus);
    }

    @Override
    public List<Order> getResponseOrderFoods(OrderFoodStatus foodStatus) {
        return null;
    }

    @Override
    public Order getOrderByOrderFood(OrderFood orderFood) {
        return null;
    }
}
