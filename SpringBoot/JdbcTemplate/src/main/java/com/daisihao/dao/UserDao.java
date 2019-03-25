package com.daisihao.dao;

import com.daisihao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user){
        jdbcTemplate.update("insert into user(name,password,email,birthday) values (?,?,?,?)",new Object[]{user.getName(),user.getPassword(),user.getEmail(),user.getDate()});
    }
}
