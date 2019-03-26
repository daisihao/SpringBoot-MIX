package com.daisihao.service;

import com.daisihao.pojo.User;

public interface UserService {

    User findUserById(int id);
    void saveUser(User user);
}
