package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.model.User;

import java.util.List;

public interface UserService {



    public List<User> getUserList();

    public User login(User user);

    public User getUserById(int id);

    public int updatePassword(User user);

}
