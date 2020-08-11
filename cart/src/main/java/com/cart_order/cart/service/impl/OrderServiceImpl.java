package com.cart_order.cart.service.impl;

import com.cart_order.cart.dto.OrderHistory;
import com.cart_order.cart.entity.Orders;
import com.cart_order.cart.repository.OrderRepository;
import com.cart_order.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    public void add(String userId, String productId,int quantity)
    {

//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
//        Date date=new Date();
//        try {
//            date =simpleDateFormat.parse(date.toString());
//        }
//        catch (Exception e)
//        {
//
//        }
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = date.format(formatter);
        Orders orders =new Orders(userId,productId,quantity,LocalDateTime.parse(formatDateTime,formatter));
        orderRepository.save(orders);
    }
    public List<Orders> getOrder(String userId)
    {
        return orderRepository.findAllByDate(userId);
    }


    public List<OrderHistory> getOrderHistory(String userId){
        return orderRepository.findAllOrdersByDate(userId);
    }
}
