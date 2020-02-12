package com.epam.AWSKyc.controllers;

import com.epam.AWSKyc.beans.UserInfo;
import com.epam.AWSKyc.beans.UserRegistrationInfo;
import com.epam.AWSKyc.service.UserRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class UserRegistryController {

    private static final Logger logger= LoggerFactory.getLogger(UserRegistryController.class);
    @Autowired
    private UserRegistryService userRegistrationService;
    @PostMapping("/register")
    public UserInfo UserRegistration(@RequestBody UserRegistrationInfo userRegistrationInfo){
        logger.info("oject "+userRegistrationInfo);
        if(!Objects.isNull(userRegistrationInfo) && !Objects.isNull(userRegistrationInfo.getUserName())) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userRegistrationInfo.getUserName());
            userInfo.setUserType(userRegistrationInfo.getUserType());
            if(!userRegistrationService.registerUser(userInfo)){
                throw new RuntimeException("Duplicate user name");
            }
            return userInfo;
        }else{
            throw new RuntimeException("Bad Request");
        }

    }
    @GetMapping("/users")
    public Object[] getUserInfoList(){
    return userRegistrationService.getListUsers();
    }

    @PostMapping("/login")
    public UserInfo login(@RequestBody  UserInfo userInfo){

        UserInfo info=userRegistrationService.getUserByName(userInfo.getUserName());
        return info;
       /* if(userInfo.getPassword().equals(info.getPassword()))
        {
            userInfo.setPassword("#####");
            userInfo.setUserType(info.getUserType());
            return info;
        }else
            return null;*/


    }

}
