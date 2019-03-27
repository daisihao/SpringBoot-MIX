package com.daisihao.dao;

import com.daisihao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
//这里的Integer是指表中主键的数据类型
public interface UserDao extends JpaRepository<User,Integer> {
}
