package com.daisihao.service.impl;

import com.daisihao.dao.UserMapper;
import com.daisihao.pojo.User;
import com.daisihao.pojo.UserExample;
import com.daisihao.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> findUsers(int page, int rows) {
        UserExample userExample = new UserExample();
        PageHelper.startPage(page,rows);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
