package com.epam.AWSKyc.beans;

import com.epam.AWSKyc.beans.constants.UserType;
import lombok.Data;

@Data
public class UserInfo {

    private String userName;
    private UserType userType;
    private String password;
    private String mobileNumber;


}
