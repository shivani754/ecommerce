package com.cart_order.cart.service;


import com.cart_order.cart.dto.OrderHistory;
import com.cart_order.cart.entity.Orders;

import java.util.List;

public interface OrderService {
    void add(String userId, String product_id,int quantity);
    List<Orders> getOrder(String userId);
    public List<OrderHistory> getOrderHistory(String userId);
}
