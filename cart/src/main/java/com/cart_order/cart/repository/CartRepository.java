package com.cart_order.cart.repository;

import com.cart_order.cart.dto.OrderHistory;
import com.cart_order.cart.entity.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<UserCart,String> {

    Optional<UserCart> findByUserIdAndProductId(String user, String productId);

    @Query(value="SELECT * FROM cart WHERE user_id = ?1 ORDER BY product_id ASC",nativeQuery = true)
    List<UserCart> findAllByOrderASC(String usedId);
    void deleteByUserId(String userId);



}
