package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.mapper.UserMapper;
import com.example.waterdeliverysystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }
}
