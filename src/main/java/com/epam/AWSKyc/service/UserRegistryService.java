package com.epam.AWSKyc.service;

import com.epam.AWSKyc.beans.UserInfo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserRegistryService {

    private static ConcurrentHashMap<String, UserInfo> registeredUsers=new ConcurrentHashMap<>();

    public UserInfo getUserByName(String name){
        return registeredUsers.get(name);
    }
    public boolean registerUser(UserInfo userInfo){
        synchronized (this) {
            if (!registeredUsers.containsKey(userInfo.getUserName())) {
                registeredUsers.put(userInfo.getUserName(), userInfo);
                System.out.println(registeredUsers.size());
                return true;
            } else {
                return false;
            }
        }
    }

    public Object[] getListUsers(){

        return registeredUsers.entrySet().toArray();
    }



}
