package com.epam.AWSKyc.beans;

import com.epam.AWSKyc.beans.constants.UserType;
import lombok.Data;

@Data
public class UserRegistrationInfo {
    private String userName;
    private UserType userType;
    private String password;
    private String mobileNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
