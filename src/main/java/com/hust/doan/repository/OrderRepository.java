package com.hust.doan.repository;

import com.hust.doan.model.Order;
import com.hust.doan.model.OrderFood;
import com.hust.doan.model.type.OrderFoodStatus;
import com.hust.doan.model.type.OrderStatus;
import com.hust.doan.payload.response.RequestOrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "select o.id, of.food_id, t.name as table_name, f.name as food_name, of.amount, o.created_date " +
            "from orders o join order_food of on o.id = of.order_id join food f on f.id = of.food_id join tables t on t.id = o.table_id order by o.created_date desc ")
    List<RequestOrderDTO> getRequestOrders();

    @Query("select o, ofd from Order o join OrderFood ofd on o.id = ofd.order.id where ofd.orderFoodStatus = 1")
    List<Order> getOrderFoodsByStatus(OrderFoodStatus foodStatus);

//    @Query("select o from Order o join OrderFood ofd on ")
//    Order getOrderByOrderFood(OrderFood orderFood);
}
