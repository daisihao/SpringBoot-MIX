package com.daisihao.dao;

import com.daisihao.pojo.User;
import com.daisihao.pojo.UserExample;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}