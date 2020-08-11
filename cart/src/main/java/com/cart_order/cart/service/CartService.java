package com.cart_order.cart.service;


import com.cart_order.cart.entity.UserCart;

import java.util.List;

public interface CartService {
    List<UserCart> add(String userId, String product_id);
    List<UserCart> mergeCart(String userId,String productId);
    List<UserCart> getOrder(String userId);
    List<UserCart>deleteProduct(String userId,String productId);
    List<UserCart>decreaseProduct(String userId,String productId);
    void deleteAllById(String userId);
}
