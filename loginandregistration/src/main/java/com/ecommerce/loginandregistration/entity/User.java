package com.ecommerce.loginandregistration.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "CUSTOMER")
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_gen_alias")
    @GenericGenerator(name= "seq_gen_alias",strategy = "uuid2")
    String userId;
    String userName;
    String emailId;
    BigInteger phoneNumber;
    String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}