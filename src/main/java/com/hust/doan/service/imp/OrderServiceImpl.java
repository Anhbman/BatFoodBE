package com.hust.doan.service.imp;

import com.hust.doan.exception.WebServiceException;
import com.hust.doan.model.Order;
import com.hust.doan.model.Table;
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

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Autowired
    private OrderFoodService orderFoodService;

    @Autowired
    private TableService tableService;

    @Override
    public Order addOrder(OrderDTO request) {
        Table table = tableService.findById(request.getTable().getId());
        if (!table.getActive()) {
            throw new WebServiceException("Bàn " + table.getName() + " không được active!");
        }

        if (table.getStatus()) {
            throw new WebServiceException("Bàn " + table.getName() + " đang được sử dụng!");
        }

        Order order = new Order(request.getTable());
        order.setOrderStatus(OrderStatus.REQUEST);
        orderFoodService.addOrderFoods(orderRepository.save(order), request.getOrderFood());
        return order;
    }
}
