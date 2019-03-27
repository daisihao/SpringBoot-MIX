package com.daisihao.service.impl;

import com.daisihao.dao.UserDao;
import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void delUser(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
