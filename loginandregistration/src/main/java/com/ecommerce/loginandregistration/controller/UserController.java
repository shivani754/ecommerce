package com.ecommerce.loginandregistration.controller;


import com.ecommerce.loginandregistration.dto.UserDTO;
import com.ecommerce.loginandregistration.entity.User;
import com.ecommerce.loginandregistration.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ecommerce")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/registeruser")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) throws Exception {

        String tempEmail  = userDTO.getEmailId();
        User user= new User();
        BeanUtils.copyProperties(userDTO,user);
        if(tempEmail!=null && !"".equals(tempEmail)){

            User userObj = userService.getUserByEmailId(tempEmail);

            if(userObj!=null){

                 throw new  Exception("User with "+ tempEmail + "Already Exist.");
            }
        }
        User userObj= null;

        userObj= userService.save(user);

        UserDTO userDTO1 = new UserDTO();
        BeanUtils.copyProperties(userObj,userDTO1);
        return  userDTO1;
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody UserDTO userDTO) throws Exception {

        String tempMail = userDTO.getEmailId();
        String password = userDTO.getPassword();
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        User user1= null;
        if( tempMail!=null && password!=null){

          user1= userService.getUserByEmailId(tempMail);

        }
        boolean flag = userService.checkPassword(user.getPassword(),user1.getPassword());
        if(user1!=null && flag){
            UserDTO userDTO1= new UserDTO();
            BeanUtils.copyProperties(user1,userDTO1);
            return userDTO1;
        }
        else{

            throw  new Exception("Bad Credentials");
        }


    }




}
