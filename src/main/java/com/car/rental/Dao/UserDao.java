package com.car.rental.Dao;

import com.car.rental.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private Map<String, User> userMap;
    private static UserDao userDao =null;
    private UserDao(){
        this.userMap = new HashMap<>();
    }
    public static UserDao getInstance(){
        if(userDao==null)
            return new UserDao();
        return userDao;
    }
    public boolean saveUser(List<User> users){
        for(User user:users){
            userMap.putIfAbsent(user.getDrivingLicense(),user);
        }
        return true;
    }
    public User getUser(String id){
        return userMap.get(id);
    }
}
