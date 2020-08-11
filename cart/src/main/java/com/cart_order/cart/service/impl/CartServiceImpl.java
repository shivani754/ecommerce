package com.cart_order.cart.service.impl;

import com.cart_order.cart.entity.UserCart;
import com.cart_order.cart.repository.CartRepository;
import com.cart_order.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    public List<UserCart> add(String userId, String productId)
    {
        if(cartRepository.findByUserIdAndProductId(userId,productId).isPresent())
        {
            UserCart userCart =cartRepository.findByUserIdAndProductId(userId, productId).get();
            userCart.setQuantity(userCart.getQuantity()+1);
            cartRepository.save(userCart);
        }
        else
        {
            UserCart userCart =new UserCart(userId,productId,1);
            cartRepository.save(userCart);
        }

       return cartRepository.findAllByOrderASC(userId);
    }


    public List<UserCart> mergeCart(String userId,String dummyId)
    {
        List<UserCart> listOfCart= cartRepository.findAllByOrderASC(dummyId);
        listOfCart.stream().forEach(userCart ->
        {
            userCart.setUserId(userId);
            System.out.println(userCart);
            cartRepository.save(userCart);
        }
        );
        return cartRepository.findAllByOrderASC(userId);
    }

    public List<UserCart> getOrder(String userId)
    {
        return cartRepository.findAllByOrderASC(userId);
    }


    public List<UserCart> deleteProduct(String userId,String productId)
    {
        UserCart cart=cartRepository.findByUserIdAndProductId(userId,productId).get();
        cartRepository.delete(cart);
        return cartRepository.findAllByOrderASC(userId);
    }


    public List<UserCart> decreaseProduct(String userId,String productId)
    {

        if(cartRepository.findByUserIdAndProductId(userId,productId).get().getQuantity() == 1) {
            UserCart userCart = cartRepository.findByUserIdAndProductId(userId,productId).get();
            userCart.setQuantity(0);
            cartRepository.delete(userCart);
        }
        else {
            UserCart cart = cartRepository.findByUserIdAndProductId(userId,productId).get();

            cart.setQuantity(cart.getQuantity()-1);
            cartRepository.save(cart);
        }
        return cartRepository.findAllByOrderASC(userId);
    }

    @Transactional
    public void deleteAllById(String userId)
    {
        cartRepository.deleteByUserId(userId);
    }
}
