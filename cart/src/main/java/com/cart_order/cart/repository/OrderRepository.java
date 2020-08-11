package com.cart_order.cart.repository;

import com.cart_order.cart.dto.OrderHistory;
import com.cart_order.cart.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,String> {

    @Query(value="SELECT * from orders WHERE user_id = ?1 ORDER BY date ASC",nativeQuery = true)
    List<Orders> findAllByDate(String userId);



    @Query(value = "SELECT "+"  date as date, count(*) as count " + " FROM orders" +
       " WHERE user_id = ?1 " +
    " GROUP BY date", nativeQuery = true)
    List<OrderHistory> findAllOrdersByDate(String userId);


}