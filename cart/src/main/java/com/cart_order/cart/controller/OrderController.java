package com.cart_order.cart.controller;

import com.cart_order.cart.dto.OrderHistory;
import com.cart_order.cart.entity.Orders;
import com.cart_order.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value="/{userId}/{productId}")
    public void add(@PathVariable("userId") String userId,@PathVariable("productId") String productId, @RequestBody int quantity)
    {
        orderService.add(userId,productId,quantity);
    }

    @GetMapping(value="/{userId}")
    public List<Orders> getOrder(@PathVariable("userId") String userId)
    {
        return orderService.getOrder(userId);
    }

    @GetMapping(value="/orderhistory/{userId}")
    public List<OrderHistory> getHistoryOrder(@PathVariable("userId") String userId){
        return orderService.getOrderHistory(userId);
    }

}