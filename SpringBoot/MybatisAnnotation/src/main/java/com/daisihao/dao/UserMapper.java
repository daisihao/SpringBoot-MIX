package com.daisihao.dao;

import com.daisihao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User findUserById(@Param("id") int id);

    @Insert("insert into user (name,password,email) values (#{name},#{password},#{email})")
    void addUser(@Param("name") String name,@Param("password") String password,@Param("email") String email);
}
