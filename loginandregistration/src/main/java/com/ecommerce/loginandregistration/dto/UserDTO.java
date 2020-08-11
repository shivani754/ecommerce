package com.ecommerce.loginandregistration.dto;

import java.math.BigInteger;

public class UserDTO {

    String userId;
    String userName;
    String emailId;
    BigInteger phoneNumber;
    String password;

    public UserDTO() {

    }

    public UserDTO(String userId, String userName, String emailId, BigInteger phoneNumber, String password) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

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
