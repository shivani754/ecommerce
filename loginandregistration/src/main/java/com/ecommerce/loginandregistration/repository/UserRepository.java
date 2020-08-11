package com.ecommerce.loginandregistration.repository;
import com.ecommerce.loginandregistration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,String> {

    public User findByEmailId(String emailId);

    public  User findByEmailIdAndPassword(String emailId,String password);
}
