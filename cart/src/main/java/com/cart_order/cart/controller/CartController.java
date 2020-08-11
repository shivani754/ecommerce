package com.cart_order.cart.controller;

import com.cart_order.cart.entity.UserCart;
import com.cart_order.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value="/{userId}")
    public List<UserCart> add(@PathVariable("userId") String userId, @RequestBody String productId)
    {
     return cartService.add(userId,productId);
    }

    @PutMapping(value="/mergecart/{userId}/{dummyUserId}")
    public List<UserCart> mergeCart(@PathVariable("userId") String userId,@PathVariable("dummyUserId") String dummyUserId)
    {
        System.out.println(dummyUserId);

        return cartService.mergeCart(userId,dummyUserId);
    }

    @GetMapping(value="{userId}")
    public List<UserCart> getOrder(@PathVariable("userId") String userId)
    {
        return cartService.getOrder(userId);
    }

    @DeleteMapping(value="/{userId}/{productId}")
    public List<UserCart> deleteproduct(@PathVariable("userId") String userId,@PathVariable("productId") String productId)
    {
        System.out.println(productId);
        return cartService.deleteProduct(userId,productId);
    }
    @PutMapping(value="/{userId}")
    public  List<UserCart> decreaseProduct(@PathVariable("userId") String userId,@RequestBody String productId)
    {
        return cartService.decreaseProduct(userId,productId);
    }

    @PutMapping(value="/increase/{userId}")
    public List<UserCart> increaseProduct(@PathVariable("userId") String userId, @RequestBody String product_id)
    {
        return cartService.add(userId,product_id);
    }
    @DeleteMapping(value="/delete/{userId}")
    public boolean deleteAll(@PathVariable("userId") String userId)
    {
        System.out.println("delete called");
        cartService.deleteAllById(userId);
        return true;
    }
}
