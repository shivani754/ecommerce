package com.ecommerce.loginandregistration.service.impl;

import com.ecommerce.loginandregistration.entity.User;
import com.ecommerce.loginandregistration.repository.UserRepository;
import com.ecommerce.loginandregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return  userRepository.save(user);
    }

    @Override
    public User getUserByEmailId(String emailId) {

        return userRepository.findByEmailId(emailId);
    }

    @Override
    public User getUserByEmailIdAndPassword(String emailId, String password) {


        return userRepository.findByEmailIdAndPassword(emailId,password);
    }

    @Override
    public boolean checkPassword(String password , String encoderpassword) {


         return passwordEncoder.matches(password,encoderpassword);
    }
}
