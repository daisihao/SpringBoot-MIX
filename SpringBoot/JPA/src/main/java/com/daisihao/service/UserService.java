package com.daisihao.service;

import com.daisihao.pojo.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void delUser(int id);
    List<User> getUsers();
}
