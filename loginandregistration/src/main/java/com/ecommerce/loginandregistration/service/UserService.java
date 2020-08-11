package com.ecommerce.loginandregistration.service;

import com.ecommerce.loginandregistration.entity.User;

public interface UserService {

    public User save(User user);

    public User getUserByEmailId(String emailId);

    public User getUserByEmailIdAndPassword(String emailId,String password);

    boolean checkPassword(String password, String encoderpassword);
}
