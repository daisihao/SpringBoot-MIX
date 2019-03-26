package com.daisihao.service.impl;

import com.daisihao.dao.UserMapper;
import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();
        userMapper.addUser(name,password,email);
    }
}
