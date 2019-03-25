package com.daisihao.service;

import com.daisihao.dao.UserDao;
import com.daisihao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(User user){
        userDao.addUser(user);
    }
}
